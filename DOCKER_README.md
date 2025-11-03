## Configuração Docker para Aplicação Fullstack Radarius

Este repositório contém a **configuração do Docker** para executar a aplicação com uma API em **Spring Boot** e frontend em **Vue.js**.

-----

## Pré-requisitos

  - Docker Desktop (Windows) ou Docker Engine (Linux)
  - Docker Compose
  - Conexão com a internet para o Oracle Database

-----

## Estrutura do Projeto

```
API-4SEM/
├── API-4SEM-BACKEND/          # Backend Spring Boot
│   ├── Dockerfile
│   ├── .dockerignore
│   └── Wallet_radarius/       # Arquivo do Oracle Wallet
├── API-4SEM-FRONTEND/         # Frontend em Vue.js
│   ├── Dockerfile
│   ├── .dockerignore
│   └── nginx.conf
└── docker-compose.yml         # Arquivo principal do Docker Compose
```

-----

## Início Rápido

1.  **Clone o repositório e baixe o conteúdo dos submódulos** (se ainda não o fez):

    ```bash
    git clone <repository-url>
    cd API-4SEM
    git submodule update --init --recursive
    ```

2.  **Crie e inicie a aplicação**:

    ```bash
    docker-compose up --build
    ```

3.  **Acesse a aplicação**:

      - Frontend: http://localhost
      - API Backend: http://localhost:8080
      - Verificação de Saúde do Backend (Health Check): http://localhost:8080/actuator/health

-----

## Comandos Disponíveis

### Criar e Iniciar (Build and Start)

```bash
# Crie e inicie todos os serviços
docker-compose up --build

# Inicie em modo desconectado (detached mode)
docker-compose up -d --build

# Inicie um serviço específico
docker-compose up backend
docker-compose up frontend
```

### Parar e Limpar (Stop and Cleanup)

```bash
# Pare todos os serviços
docker-compose down

# Pare e remova os volumes
docker-compose down -v

# Pare e remova as imagens
docker-compose down --rmi all
```

### Comandos de Desenvolvimento (Development Commands)

```bash
# Visualize os logs
docker-compose logs -f

# Visualize os logs de um serviço específico
docker-compose logs -f backend
docker-compose logs -f frontend

# Execute comandos em um contêiner em execução
docker-compose exec backend bash
docker-compose exec frontend sh

# Recrie (rebuild) um serviço específico
docker-compose build backend
docker-compose build frontend
```

-----

## Serviços

### Backend (Spring Boot)

  - **Porta**: 8080
  - **Versão Java**: 21
  - **Framework**: Spring Boot 3.5.5
  - **Banco de Dados**: Oracle (usando autenticação via *wallet*)
  - **Verificação de Saúde (Health Check)**: `/actuator/health`

### Frontend (Vue.js)

  - **Porta**: 80
  - **Versão Node**: 20
  - **Framework**: Vue.js 3 com Vite
  - **Servidor Web**: Nginx
  - **Proxy de API**: Redireciona as rotas `/api/*` para o backend

-----

## Variáveis de Ambiente

A aplicação usa as seguintes **variáveis de ambiente**:

  - `TNS_NAME`: Nome TNS do Oracle (padrão: radarius\_high)
  - `WALLET_DIR`: Caminho para o diretório do *wallet* Oracle
  - `SPRING_PROFILES_ACTIVE`: Perfil Spring (padrão: default)

-----

## Conexão com o Banco de Dados

A aplicação está configurada para conectar-se a um banco de dados Oracle usando:

  - Autenticação baseada em *Wallet*
  - *Connection pooling* com Oracle UCP
  - Configuração TNS

Certifique-se de que seu banco de dados Oracle esteja acessível e os arquivos do *wallet* estejam configurados corretamente.

-----

## Solução de Problemas (Troubleshooting)

### Problemas Comuns (Common Issues)

1.  **Conflitos de portas**: Se as portas 80 ou 8080 já estiverem em uso, modifique as portas no `docker-compose.yml`

2.  **Problemas de conexão com o Banco de Dados**:

      - Verifique se o banco de dados Oracle está em execução
      - Verifique se os arquivos do *wallet* estão montados corretamente
      - Verifique a configuração TNS

3.  **Falhas na Criação (*Build failures*)**:

      - Verifique se o *daemon* do Docker está em execução
      - Verifique se todos os arquivos necessários estão presentes
      - Verifique os logs do Docker: `docker-compose logs`

### Verificações de Saúde (Health Checks)

Ambos os serviços incluem verificações de saúde:

  - Backend: Verifica o *endpoint* `/actuator/health`
  - Frontend: Verifica se o *nginx* está servindo o conteúdo

### Logs

Visualize os logs para depuração (*debugging*):

```bash
# Todos os serviços
docker-compose logs -f

# Serviço específico
docker-compose logs -f backend
docker-compose logs -f frontend
```

-----

## Desenvolvimento (Development)

Para desenvolvimento, você pode executar serviços individuais ou modificar o arquivo `docker-compose.yml` para atender às suas necessidades.

### Modificando a Configuração

  - **Backend**: Modifique `API-4SEM-BACKEND/src/main/resources/application.yaml`
  - **Frontend**: Modifique `API-4SEM-FRONTEND/vite.config.ts` ou `nginx.conf`
  - **Docker**: Modifique `docker-compose.yml` para configuração de serviço

-----

## Considerações sobre Produção (Production Considerations)

Para implantação em produção:

1.  Use arquivos de configuração específicos para o ambiente
2.  Configure o gerenciamento adequado de segredos (*secrets management*)
3.  Configure certificados SSL/TLS
4.  Configure monitoramento e registro (*logging*)
5.  Use configurações de banco de dados de nível de produção
6.  Considere usar Docker Swarm ou Kubernetes para orquestração

-----

## Suporte

Para problemas relacionados a:

  - Configuração Docker: Verifique este README e os logs do Docker
  - Funcionalidade da aplicação: Verifique a documentação principal do projeto
  - Conectividade do Banco de Dados: Verifique o banco de dados Oracle e a configuração do *wallet*
