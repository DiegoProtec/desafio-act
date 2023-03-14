CREATE TABLE produto (
   cod_produto INT PRIMARY KEY,
   nome VARCHAR(50) NOT NULL,
   descricao VARCHAR(150) NULL,
   valor NUMERIC NOT NULL,
   estoque INT NOT NULL
);

CREATE TABLE item_compra (
   cod_produto INT NOT NULL,
   cod_compra INT NOT NULL,
   quantidade INT NOT NULL,
   valor NUMERIC NOT NULL,
   FOREIGN KEY (cod_produto) REFERENCES produto(cod_produto)
   FOREIGN KEY (cod_compra) REFERENCES compra(cod_compra)
);

CREATE TABLE compra (
   cod_compra INT PRIMARY KEY,
   data DATE NOT NULL,
   login VARCHAR(50) NOT NULL,
   valor NUMERIC NOT NULL,
   itens INT NOT NULL
);