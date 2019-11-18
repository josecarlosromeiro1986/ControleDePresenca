create database controle_presenca;

use controle;

CREATE TABLE palestrante (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE participante (
    codigo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    fone VARCHAR(9) NOT NULL,
    idPalestra int not null
);

CREATE TABLE controle (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_entrada DATETIME NOT NULL,
    data_saida DATETIME NOT NULL,
    idParticipante INT NOT NULL,
    idPalestra INT NOT NULL
);

CREATE TABLE palestra (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(145) NOT NULL,
    data_palestra DATETIME NOT NULL,
    id_palestrante INT NOT NULL
);

insert into participante values (null, 'José', '12349987521', '996587734', '1'), 
(null, 'Lucas', '65875487631', '995472587', '1'), 
(null, 'Eric', '87435114887', '995874635', '1'), 
(null, 'João S', '54862153487', '995642235', '1'), 
(null, 'João G', '56128554372', '995342567', '1');

insert into palestrante values (null, 'Lula Livre');

insert into palestra values (null, 'Como ser Presidente com apenas 9 dedos', '2019-11-19 19:40:00', '1');