CREATE TABLE options_q20_formulario_alimentar
(
    id_options_q20  BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao       VARCHAR(100) NOT NULL,
    criado_em       DATETIME,
    criado_por_id   BIGINT,
    alterado_em     DATETIME,
    alterado_por_id BIGINT,
    is_active       TINYINT DEFAULT 1
);

INSERT INTO options_q20_formulario_alimentar (descricao)
VALUES ('No almoço (1 vez ao dia)'),
       ('No jantar'),
       ('No almoço e no jantar (2 vezes ao dia)');
