import pandas as pd
from sqlalchemy import create_engine
import os
from datetime import datetime
import logging
from typing import Optional
import re
from sqlalchemy import text

# Configuração de logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

class RadarDataProcessor:
    def __init__(self, connection_string: str, chunk_size: int = 10000):
        """
        Inicializa o processador de dados de radar
        
        Args:
            connection_string: String de conexão SQLAlchemy (oracle+oracledb://user:password@host:port/service_name)
            chunk_size: Tamanho do chunk para processamento em lotes
        """
        self.connection_string = connection_string
        self.chunk_size = chunk_size
        self.engine = None
        
    def connect(self):
      """Estabelece conexão com o banco Oracle"""
      try:
          self.engine = create_engine(self.connection_string)
          # Teste a conexão e verifica o usuário atual
          with self.engine.connect() as conn:
              conn.execute(text("SELECT 1 FROM DUAL")).fetchone()
              result = conn.execute(text("SELECT USER FROM DUAL")).fetchone()
              logger.info(f"Conectado como usuário: {result[0]}")
          logger.info("Conexão com Oracle estabelecida com sucesso")
      except Exception as e:
          logger.error(f"Erro ao conectar com Oracle: {e}")
          raise
      
    def disconnect(self):
        """Fecha a conexão com o banco"""
        if self.engine:
            self.engine.dispose()
            logger.info("Conexão fechada")
    
    def parse_camera_info(self, camera_numero: str) -> tuple:
        """
        Extrai informações da câmera a partir do campo camera_numero
        
        Args:
            camera_numero: String no formato "L0641_3" ou "00356_1"
            
        Returns:
            tuple: (camera_id, faixa_da_camera, quantidade_de_faixas)
        """
        try:
            # Remove prefixo 'L' se existir e separa por '_'
            clean_number = str(camera_numero).replace('L', '')
            parts = clean_number.split('_')
            
            camera_id = parts[0]
            faixa_da_camera = int(parts[1]) if len(parts) > 1 else 1
            
            # Estimativa básica da quantidade de faixas baseada na faixa atual
            quantidade_de_faixas = max(faixa_da_camera, 2)
            
            return camera_id, faixa_da_camera, quantidade_de_faixas
        except (IndexError, ValueError) as e:
            logger.warning(f"Erro ao processar camera_numero '{camera_numero}': {e}")
            return str(camera_numero), 1, 2
    
    def parse_endereco(self, endereco: str) -> tuple:
        """
        Extrai informações do endereço
        
        Args:
            endereco: String completa do endereço
            
        Returns:
            tuple: (endereco_limpo, numero, cidade, sentido)
        """
        if pd.isna(endereco):
            return "Endereço não informado", None, "São José dos Campos", None
            
        endereco = str(endereco).strip()
        
        # Extrai número (padrão: nº 123 ou n° 123)
        numero = None
        numero_match = re.search(r'n[°º]\s*(\d+)', endereco, re.IGNORECASE)
        if numero_match:
            numero = numero_match.group(1)
        
        # Extrai cidade (geralmente após vírgula)
        cidade = "São José dos Campos"  # Padrão baseado nos dados
        if "," in endereco:
            parts = endereco.split(",")
            for part in parts:
                if "São José dos Campos" in part:
                    cidade = "São José dos Campos"
                    break
        
        # Extrai sentido (palavras-chave comuns)
        sentido = None
        sentido_keywords = ["Sentido", "B/C", "C/B", "Norte", "Sul", "Leste", "Oeste"]
        for keyword in sentido_keywords:
            if keyword in endereco:
                # Extrai a parte que contém o sentido
                idx = endereco.find(keyword)
                sentido_part = endereco[idx:idx+50]  # Pega até 50 chars após a palavra-chave
                sentido = sentido_part.split(",")[0].strip()
                break
        
        # Limpa o endereço removendo informações já extraídas
        endereco_limpo = endereco.split(",")[0].strip()
        if numero and f"nº {numero}" in endereco_limpo:
            endereco_limpo = endereco_limpo.replace(f"nº {numero}", "").strip()
        if numero and f"n° {numero}" in endereco_limpo:
            endereco_limpo = endereco_limpo.replace(f"n° {numero}", "").strip()
        
        return endereco_limpo[:200], numero, cidade[:100], sentido[:50] if sentido else None
    
    def normalize_tipo_veiculo(self, tipo: str) -> str:
        """
        Normaliza o tipo de veículo para os valores aceitos pelo constraint
        
        Args:
            tipo: Tipo original do veículo
            
        Returns:
            str: Tipo normalizado
        """
        if pd.isna(tipo):
            return 'INDEFINIDO'
            
        tipo = str(tipo).upper().strip()
        
        mapping = {
            'CARRO': 'CARRO',
            'CAMIONETE': 'CAMIONETE',
            'CAMINHÃO GRANDE': 'CAMINHÃO GRANDE',
            'MOTO': 'MOTO',
            'ÔNIBUS': 'ÔNIBUS',
            'VAN': 'VAN',
            'INDEFINIDO': 'INDEFINIDO'
        }
        
        return mapping.get(tipo, 'INDEFINIDO')
    
    def process_chunk(self, chunk_df: pd.DataFrame) -> pd.DataFrame:
        """
        Processa um chunk de dados e prepara DataFrame para inserção
        
        Args:
            chunk_df: DataFrame com os dados do chunk
            
        Returns:
            pd.DataFrame: DataFrame processado para inserção
        """
        processed_rows = []
        
        for _, row in chunk_df.iterrows():
            try:
                # Parse das informações da câmera
                camera_id, faixa_da_camera, quantidade_de_faixas = self.parse_camera_info(row['camera_numero'])
                
                # Parse do endereço
                endereco_limpo, numero, cidade, sentido = self.parse_endereco(row['endereco'])
                
                # Normalização do tipo de veículo
                tipo_veiculo = self.normalize_tipo_veiculo(row['tipoVeiculo'])
                
                # Conversão da data
                data_hora = pd.to_datetime(row['DataHoraTz'])
                
                # Monta dicionário para o DataFrame
                processed_row = {
                    'camera_lat': float(row['camera_latitude']),
                    'camera_long': float(row['camera_longitude']),
                    'camera_id': camera_id,
                    'faixa_da_camera': faixa_da_camera,
                    'quantidade_de_faixas': quantidade_de_faixas,
                    'data_hora': data_hora,
                    'tipo_veiculo': tipo_veiculo,
                    'velocidade_veiculo': float(row['velocidade']),
                    'velocidade_regulamentada': int(row['velocidadeRegulamentada']),
                    'endereco': endereco_limpo,
                    'numero': numero,
                    'cidade': cidade,
                    'sentido': sentido
                }

                processed_rows.append(processed_row)
                
            except Exception as e:
                logger.warning(f"Erro ao processar linha: {e}")
                continue
        
        return pd.DataFrame(processed_rows)
    
    def insert_chunk(self, processed_df: pd.DataFrame):
      """
      Insere um chunk de dados no banco usando pandas to_sql
      
      Args:
          processed_df: DataFrame processado para inserção
      """
      if processed_df.empty:
          return
      
      try:
          from sqlalchemy.dialects import oracle
          
          # Define os tipos de dados específicos para Oracle
          dtype_mapping = {
              'camera_lat': oracle.NUMBER(precision=15, scale=10),
              'camera_long': oracle.NUMBER(precision=15, scale=10),
              'camera_id': oracle.VARCHAR2(50),
              'faixa_da_camera': oracle.NUMBER(precision=2),
              'quantidade_de_faixas': oracle.NUMBER(2),
              'data_hora': oracle.TIMESTAMP(),
              'tipo_veiculo': oracle.VARCHAR2(20),
              'velocidade_veiculo': oracle.NUMBER(precision=5, scale=2),
              'velocidade_regulamentada': oracle.NUMBER(3),
              'endereco': oracle.VARCHAR2(200),
              'numero': oracle.VARCHAR2(10),
              'cidade': oracle.VARCHAR2(100),
              'sentido': oracle.VARCHAR2(50)
          }
          
          # Usar uma transação explícita
          with self.engine.begin() as conn:
              # Inserção usando pandas to_sql com tipos específicos
              processed_df.to_sql(
                  'dados_radares', 
                  conn, 
                  if_exists='append', 
                  index=False,
                  chunksize=self.chunk_size,  # Usando o chunk_size da classe
                  dtype=dtype_mapping
              )
          
          logger.info(f"Inseridos {len(processed_df)} registros com sucesso")
          
      except Exception as e:
          logger.error(f"Erro ao inserir dados: {e}")
          raise
    
    def process_file(self, csv_file_path: str):
      """
      Processa todo o arquivo CSV
      
      Args:
          csv_file_path: Caminho para o arquivo CSV
      """
      logger.info(f"Iniciando processamento do arquivo: {csv_file_path}")
      
      total_processed = 0
      
      # Lê o arquivo em chunks
      for chunk_num, chunk_df in enumerate(pd.read_csv(csv_file_path, chunksize=self.chunk_size), 1):
          logger.info(f"Processando chunk {chunk_num} ({len(chunk_df)} registros)")
          
          # Processa o chunk
          processed_df = self.process_chunk(chunk_df)
          
          # Insere no banco
          if not processed_df.empty:
              self.insert_chunk(processed_df)
              total_processed += len(processed_df)
              
              # Verifica se os dados foram realmente inseridos
              with self.engine.connect() as conn:
                  result = conn.execute(text("SELECT COUNT(*) FROM dados_radares")).fetchone()
                  logger.info(f"Total de registros na tabela após inserção: {result[0]}")
          
          logger.info(f"Chunk {chunk_num} concluído. Total processado: {total_processed}")
      
      logger.info(f"Processamento completo! Total de registros inseridos: {total_processed}")

def main():
    # Configurações para o Docker Oracle com SQLAlchemy
    CONNECTION_STRING = "oracle+oracledb://usuario:senha@endereco-do-banco:1521/XE"
    CSV_FILE_PATH = "/caminho-do-csv/arquivo.csv"
    CHUNK_SIZE = 1000
    
    # Cria o processador
    processor = RadarDataProcessor(CONNECTION_STRING, CHUNK_SIZE)
    
    try:
        # Conecta ao banco
        processor.connect()
        
        # Processa o arquivo
        processor.process_file(CSV_FILE_PATH)
        
    except Exception as e:
        logger.error(f"Erro durante o processamento: {e}")
        
    finally:
        # Fecha a conexão
        processor.disconnect()

if __name__ == "__main__":
    main()

