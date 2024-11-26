CREATE TABLE pessoas (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    isPresent BOOLEAN,
    foto_url VARCHAR(255)
);
