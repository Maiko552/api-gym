CREATE TABLE pessoas (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    is_present BOOLEAN DEFAULT TRUE,
    foto_url VARCHAR(255),
    pago DATE
);
