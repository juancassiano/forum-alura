alter table usuario add codigo varchar(36) not null after id;
update usuario set codigo = uuid();
alter table usuario add constraint uk_usuario_codigo unique (codigo);


alter table topico add codigo varchar(36) not null after id;
update topico set codigo = uuid();
alter table topico add constraint uk_topico_codigo unique (codigo);


alter table curso add codigo varchar(36) not null after id;
update curso set codigo = uuid();
alter table curso add constraint uk_curso_codigo unique (codigo);