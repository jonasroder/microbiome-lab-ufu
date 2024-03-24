CREATE TABLE problema_entusiasmo
(
    id_problema_entusiasmo TINYINT AUTO_INCREMENT PRIMARY KEY,
    descricao              VARCHAR(100) NOT NULL,
    criado_em              DATETIME,
    criado_por_id          BIGINT,
    alterado_em            DATETIME,
    alterado_por_id        BIGINT,
    is_active              TINYINT DEFAULT 1
);

INSERT INTO problema_entusiasmo (descricao)
VALUES ('Nenhuma dificuldade'),
       ('Um problema muito leve'),
       ('Um problema razoável'),
       ('Um problema muito grande');
