CREATE TABLE conta
(
    id_conta IDENTITY NOT NULL PRIMARY KEY,
    nome_responsavel VARCHAR(50) NOT NULL
);


CREATE TABLE transferencia
(
    id bigint IDENTITY NOT NULL PRIMARY KEY,
    data_transferencia TIMESTAMP WITH TIME ZONE NOT NULL,
    valor NUMERIC (20,2) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    nome_operador_transacao VARCHAR (50),
    conta_id INT NOT NULL,

        CONSTRAINT FK_CONTA
        FOREIGN KEY (conta_id)
        REFERENCES conta(id_conta)
);

INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (3, 'Beltrano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (4, 'Ronnyscley');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (5, 'Ciclano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (6, 'Fulana');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (7, 'Sicrana');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (8, 'João');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (9, 'Maria');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (10, 'Pedro');

INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', null, 1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', null,1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2019-08-07 08:12:45+03',-530.50,'SAQUE', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7, '2020-01-01 12:00:00+03', 100.00, 'DEPOSITO', NULL, 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8, '2020-02-15 09:53:27+03', 50.50, 'DEPOSITO', NULL, 4);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9, '2020-03-20 08:12:45+03', -20.00, 'SAQUE', 'Ciclano', 5);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10, '2020-04-10 08:12:45+03', -75.25, 'SAQUE', NULL, 6);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11, '2020-06-08 10:15:01+03', 300.00, 'TRANSFERENCIA', 'Sicrana', 7);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12, '2021-04-01 12:12:04+03', 500.75, 'TRANSFERENCIA', 'João', 8);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (13, '2022-03-15 10:10:10+03', 120.30, 'TRANSFERENCIA', 'Maria', 9);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (14, '2022-12-31 20:30:00+03', 70.00, 'DEPOSITO', 'Pedro', 10);
