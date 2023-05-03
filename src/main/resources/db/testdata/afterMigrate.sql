set foreign_key_checks = 0;

delete from usuario;
delete from curso;
delete from resposta;
delete from topico;

set foreign_key_checks = 1;

alter table usuario auto_increment = 1;
alter table curso auto_increment = 1;
alter table resposta auto_increment = 1;
alter table topico auto_increment = 1;

insert into curso(id,codigo, nome, categoria) values (1,'a9b9ee42-5af4-4ce7-ae80-89a33ec5ca16', 'Java', 'Backend');
insert into curso(id,codigo, nome, categoria) values (2,'49e3cdd4-47e5-4fd8-89ad-24dfaffa70b8', 'React', 'Frontend');

insert into usuario(id,codigo, nome, email, senha) values(1,'c6151c11-64e7-41ad-8f9f-bec1e210546c', 'Juan', 'juancassiano@hotmail.com', '123456');
insert into usuario(id,codigo, nome, email, senha) values(2,'e89fac93-5369-43d7-b341-421a7ff9df4a', 'Cassiano', 'cassianojuan@hotmail.com', '123456');
insert into usuario(id,codigo, nome, email, senha) values(3,'17ed95a8-dae3-488e-ba26-8c894d6b662f', 'Juan', 'juancassiano@alura.com', '123456');

insert into topico(id,codigo, titulo, mensagem, status, data_criacao,autor_id, curso_id) values(1,'8dfd2c8f-e59e-4f75-8081-d2009d9c1b7a', 'uso correto de Records', 'Meu record está implementado corretamente?','NAO_RESPONDIDO',utc_timestamp, 1, 1);
insert into topico(id,codigo, titulo, mensagem, status, data_criacao,autor_id, curso_id) values(2,'0c193ef9-7ed6-4ffb-b547-6fb642b63433', 'Bootstrap ou Tailwind', 'Qual CSS usar?','NAO_RESPONDIDO',utc_timestamp, 1, 2);
insert into topico(id,codigo, titulo, mensagem, status, data_criacao,autor_id, curso_id) values(3,'bc263376-6be9-468a-bf9f-067bfa7a202f', 'Spring JPA com Flyway', 'Estou com problemas para criar as migrations','NAO_RESPONDIDO',utc_timestamp, 2, 1);

insert into resposta(id,mensagem,data_criacao,status,topico_id,autor_id) values(1,'Tailwind, com toda a certeza. Leia a documentação no site', utc_timestamp,'NAO_SOLUCIONADO',2,3);
insert into resposta(id,mensagem,data_criacao,status,topico_id,autor_id) values(2,'Hey, achei incrível o uso de Records, me mande o seu github para que eu possa ver o código completo.', utc_timestamp,'NAO_SOLUCIONADO',1,3);
insert into resposta(id,mensagem,data_criacao,status,topico_id,autor_id) values(3,'Acho que é mais fácil do que criar várias DTOs, mas veja as boas práticas antes de implementar no seu código.', utc_timestamp,'NAO_SOLUCIONADO',1,2);