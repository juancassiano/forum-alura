CREATE TABLE usuario(
    id bigint not null auto_increment,
    nome varchar(60) not null,
    email varchar(255) not null,
    senha varchar(255) not null,
    primary key (id)
)engine=InnoDB default charset=utf8;

CREATE TABLE curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria varchar(255) not null
)engine=InnoDB default charset=utf8;

CREATE TABLE topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem VARCHAR(255) NOT NULL,
    status varchar(50) not null,
    data_criacao datetime not null,
    autor_id BIGINT,
    curso_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id)
)engine=InnoDB default charset=utf8;

CREATE TABLE resposta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensagem VARCHAR(255) NOT NULL,
    topico_id BIGINT,
    autor_id BIGINT,
    data_criacao datetime not null,
    solucao tinyint(1) DEFAULT 0,
    FOREIGN KEY (topico_id) REFERENCES topico(id),
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
)engine=InnoDB default charset=utf8;

