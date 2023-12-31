CREATE TABLE PACIENTES (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL unique,
    TELEFONE VARCHAR(20) NOT NULL unique,
    CPF VARCHAR(14) NOT NULL unique,
    LOGRADOURO VARCHAR(100) NOT NULL,
    BAIRRO VARCHAR(100) NOT NULL,
    CEP VARCHAR(9) NOT NULL,
    COMPLEMENTO VARCHAR(100),
    NUMERO VARCHAR(20),
    UF CHAR(2) NOT NULL,
    CIDADE VARCHAR(100) NOT NULL,
    PRIMARY KEY(ID)
);