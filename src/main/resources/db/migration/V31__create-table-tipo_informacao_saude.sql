CREATE TABLE tipo_informacao_saude
(
    id_tipo_informacao_saude BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome                     VARCHAR(255),
    descricao                TEXT,
    criado_em                DATETIME,
    criado_por_id            BIGINT,
    alterado_em              DATETIME,
    alterado_por_id          BIGINT,
    is_active                TINYINT DEFAULT 1
);


INSERT INTO tipo_informacao_saude (nome, descricao, is_active)
VALUES ('Peso', 'Peso corporal do paciente em quilogramas.', 1),
       ('Altura', 'Altura do paciente em centímetros.', 1),
       ('Pressão Sistólica', 'Pressão arterial sistólica do paciente medida em mmHg.', 1),
       ('Pressão Diastólica', 'Pressão arterial diastólica do paciente medida em mmHg.', 1),
       ('IMC', 'Índice de Massa Corporal calculado a partir do peso e altura do paciente.', 1),
       ('Glicemia de Jejum', 'Nível de glicose no sangue após um período de jejum, medido em mg/dL.', 1),
       ('Colesterol Total',
        'Medição total do colesterol no sangue, incluindo LDL, HDL e triglicerídeos, medido em mg/dL.', 1),
       ('LDL', 'Colesterol "ruim" baixa densidade, medido em mg/dL.', 1),
       ('HDL', 'Colesterol "bom" alta densidade, medido em mg/dL.', 1),
       ('Triglicerídeos', 'Tipo de gordura encontrada no sangue, medido em mg/dL.', 1),
       ('Hemoglobina Glicada',
        'Percentual de glicose sanguínea anexada à hemoglobina, indicador de controle de diabetes.', 1),
       ('Vitamina D', 'Níveis de vitamina D no sangue, medido em ng/mL.', 1),
       ('Ferro Sérico',
        'Medição de ferro disponível no soro do sangue, importante para diagnóstico de anemia, medido em µg/dL.', 1),
       ('TSH', 'Hormônio estimulante da tireoide, importante para avaliar a função tireoidiana, medido em µIU/mL.', 1),
       ('Creatinina', 'Indica a função renal, medido em mg/dL.', 1),
       ('Circunferência Abdominal', 'Medição da circunferência ao redor do abdômen do paciente em centímetros.', 1),
       ('Circunferência do Braço',
        'Medição da circunferência do braço do paciente em centímetros, importante para avaliação nutricional.', 1),
       ('Circunferência da Cintura',
        'Medição da circunferência da cintura do paciente em centímetros, indicador de risco cardiovascular.', 1),
       ('Circunferência do Quadril',
        'Medição da circunferência do quadril do paciente em centímetros, usado para calcular a relação cintura-quadril.',
        1),
       ('Relação Cintura-Quadril',
        'Razão entre as circunferências da cintura e do quadril, indicador de risco de doenças cardiovasculares e diabetes.',
        1),
       ('Percentual de Gordura Corporal',
        'Estimativa do percentual total de gordura corporal do paciente, importante para avaliação da composição corporal.',
        1),
       ('Massa Muscular',
        'Estimativa da massa muscular do paciente, importante para avaliação da saúde muscular e nutricional.', 1),
       ('Taxa de Metabolismo Basal',
        'Estimativa da quantidade mínima de energia necessária para funções vitais do corpo em repouso, medido em kcal/dia.',
        1),
       ('Níveis de Hemoglobina',
        'Concentração de hemoglobina no sangue, importante para diagnóstico de anemia, medido em g/dL.', 1),
       ('Taxa de Filtração Glomerular',
        'Estimativa da função renal, indicando a velocidade com que os rins filtram o sangue, medido em mL/min/1.73 m².',
        1),
       ('Sódio Sérico',
        'Concentração de sódio no sangue, importante para avaliar o equilíbrio eletrolítico, medido em mEq/L.', 1),
       ('Potássio Sérico', 'Concentração de potássio no sangue, vital para funções celulares, medido em mEq/L.', 1),
       ('Magnésio Sérico', 'Nível de magnésio no sangue, importante para muitas funções corporais, medido em mg/dL.',
        1),
       ('Ácido Úrico',
        'Nível de ácido úrico no sangue, importante para diagnóstico de gota e problemas renais, medido em mg/dL.', 1),
       ('PCR (Proteína C-Reativa)',
        'Marcador de inflamação no corpo, importante para detectar infecções e doenças inflamatórias, medido em mg/L.',
        1),
       ('Pressão Intraocular',
        'Medição da pressão dentro do olho, importante para diagnóstico de glaucoma, medido em mmHg.', 1),
       ('Capacidade Vital Forçada',
        'Volume máximo de ar expirado com força após uma inspiração profunda, importante para avaliação pulmonar, medido em litros.',
        1),
       ('Pico de Fluxo Expiratório',
        'Máxima velocidade de expiração, útil no diagnóstico de obstruções das vias aéreas, medido em L/min.', 1),
       ('Saturação de Oxigênio',
        'Percentual de hemoglobina saturada com oxigênio no sangue, indicativo de funções respiratórias, medido em %.',
        1),
       ('Densidade Óssea',
        'Medição da densidade mineral óssea, importante para diagnóstico de osteoporose, medido em g/cm².', 1),
       ('Níveis de Cortisol',
        'Concentração de cortisol no sangue, importante para avaliar o estresse e distúrbios adrenais, medido em µg/dL.',
        1),
       ('Testosterona Total',
        'Nível de testosterona no sangue, importante para avaliar a função endócrina e reprodutiva, medido em ng/dL.',
        1),
       ('Estradiol',
        'Nível de estradiol no sangue, importante para avaliar a função reprodutiva e hormonal, medido em pg/mL.', 1),
       ('T4 Livre',
        'Concentração de tiroxina livre no sangue, importante para avaliação da função tireoidiana, medido em ng/dL.',
        1),
       ('Anticorpos Anti-TPO',
        'Presença de anticorpos contra a tireoperoxidase, importante no diagnóstico de doenças autoimunes da tireoide, medido em IU/mL.',
        1),
       ('Vitamina B12',
        'Níveis de vitamina B12 no sangue, importante para função nervosa e formação de sangue, medido em pg/mL.', 1),
       ('Ácido Fólico',
        'Níveis de ácido fólico no sangue, crucial para a formação de células sanguíneas e saúde fetal, medido em ng/mL.',
        1),
       ('Ferritina',
        'Indica os estoques de ferro no corpo, importante para diagnóstico de anemia e sobrecarga de ferro, medido em ng/mL.',
        1),
       ('D-dímero',
        'Nível de D-dímero no sangue, útil na avaliação de coagulação e risco de trombose, medido em µg/mL.', 1),
       ('PSA Total',
        'Antígeno específico da próstata no sangue, importante para rastreamento de câncer de próstata, medido em ng/mL.',
        1);
