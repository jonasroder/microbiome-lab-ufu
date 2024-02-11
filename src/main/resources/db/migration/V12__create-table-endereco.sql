-- Criação da tabela de endereço
CREATE TABLE endereco
(
    id_endereco BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_paciente BIGINT       NOT NULL,
    logradouro  VARCHAR(255) NOT NULL,
    numero      VARCHAR(10),
    complemento VARCHAR(255),
    bairro      VARCHAR(100),
    cidade      VARCHAR(100) NOT NULL,
    id_uf       BIGINT       NOT NULL,
    cep         VARCHAR(8)   NOT NULL,
    referencia  VARCHAR(255)
)

