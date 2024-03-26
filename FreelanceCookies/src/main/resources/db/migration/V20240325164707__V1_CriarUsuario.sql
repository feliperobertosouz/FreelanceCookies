CREATE TABLE usuario (
  id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   nome VARCHAR(255),
   email VARCHAR(255),
   cpf VARCHAR(255),
   telefone VARCHAR(255),
   saldo DOUBLE PRECISION NOT NULL,
   nota DOUBLE PRECISION NOT NULL,
   avaliacoes DOUBLE PRECISION NOT NULL,
   CONSTRAINT pk_usuario PRIMARY KEY (id)
);