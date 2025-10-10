CREATE SEQUENCE seq_dados_radares
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE dados_radares (
    id NUMBER PRIMARY KEY,
    camera_lat NUMBER(10,6) NOT NULL,
    camera_long NUMBER(10,6) NOT NULL,
    camera_id VARCHAR2(50) NOT NULL,
    faixa_da_camera NUMBER(2) NOT NULL,
    quantidade_de_faixas NUMBER(2) NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    tipo_veiculo VARCHAR2(20) NOT NULL,
    velocidade_veiculo NUMBER(5,2) NOT NULL,
    velocidade_regulamentada NUMBER(3) NOT NULL,
    endereco VARCHAR2(200) NOT NULL,
    numero VARCHAR2(10),
    cidade VARCHAR2(100),
    sentido VARCHAR2(50),
    
    CONSTRAINT chk_tipo_veiculo CHECK (tipo_veiculo IN ('CAMINHÃO GRANDE', 'CAMIONETE', 'CARRO', 'INDEFINIDO', 'MOTO', 'ÔNIBUS', 'VAN'))
);

CREATE OR REPLACE TRIGGER trg_dados_radares
BEFORE INSERT ON dados_radares
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT seq_dados_radares.NEXTVAL INTO :NEW.id FROM DUAL;
    END IF;
END;

