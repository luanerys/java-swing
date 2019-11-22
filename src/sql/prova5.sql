CREATE DATABASE universidade;
USE universidade;
DROP DATABASE universidade;

CREATE TABLE aluno
(
	codigo_aluno INT PRIMARY KEY NOT NULL,
    rg VARCHAR(50),
    cpf VARCHAR (50),
    nome VARCHAR(100),
	endereco VARCHAR(100),
    telefone VARCHAR(50)
);

CREATE TABLE professor
(
	codigo_prof INT PRIMARY KEY NOT NULL,
    nome_prof VARCHAR(100),
    disciplina VARCHAR(50)
);

CREATE TABLE disciplina
(
	codigo_disc INT PRIMARY KEY NOT NULL,
    ch INT,
    disciplina VARCHAR(50),
    ementa text,
    professor VARCHAR(100)
);

CREATE TABLE curso
(
	codigo_curs INT PRIMARY KEY NOT NULL,
    curso VARCHAR(50)
);

CREATE TABLE grade 
(
	ano INT,
    codigo_disc INT,
    codigo_curs INT(50),
    foreign key (codigo_disc) references disciplina (codigo_disc),
    foreign key (codigo_curs) references curso (codigo_curs)
);

CREATE TABLE matricula_aluno
(
	codigo_aluno INT,
    codigo_curs INT,
    foreign key (codigo_aluno) references aluno (codigo_aluno),
    foreign key (codigo_curs) references curso (codigo_curs)
);

 CREATE TABLE professor_disciplina
 (
	codigo_prof INT,
    codigo_disc INT,
    foreign key (codigo_prof) references professor (codigo_prof),
    foreign key (codigo_disc) references disciplina (codigo_disc)
);

SELECT * FROM aluno;

INSERT INTO aluno (codigo_aluno,rg,cpf,nome,endereco,telefone) VALUES
(1,'895795479-2008', '015.047.968-62','Luana Alves','Rua 10','8796-6852'),
(2,'772838727-2003', '123.654.123-00','Andreia Alves','Rua 11','8574-6523');

INSERT INTO disciplina (codigo_disc,ch,disciplina,ementa,professor) VALUES
(121,90,'LPII','Etc','João'),
(134,90,'Análise II','Etc','Eveline'),
(167,90,'CNC','Etc','Karla');

INSERT INTO curso (codigo_curs,curso) VALUES
(3672, 'SI'),
(9788, 'Química');

INSERT INTO matricula_aluno (codigo_aluno, codigo_curs) VALUES
(1,3672),
(2,9788);

INSERT INTO professor (codigo_prof, nome_prof,disciplina) VALUES
(20,'João','LPII'),
(30,'Karla','CNC');

INSERT INTO professor_disciplina (codigo_prof, codigo_disc) VALUES
(20,121),
(30,167);


    
    