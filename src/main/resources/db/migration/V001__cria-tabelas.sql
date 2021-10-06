create table restaurante (
	id bigint not null auto_increment,
	nome varchar(80) not null,
	taxa_frete decimal(10,2) not null,
	data_atualizacao datetime not null,
	data_cadastro datetime not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;

create table contato (
	id bigint not null auto_increment,
	restaurante_id bigint not null,
	nome varchar(80) not null,
	email varchar(80) not null,	
	primary key (id)
) engine=InnoDB default charset=utf8;

create table endereco (
	id bigint not null auto_increment,
	restaurante_id bigint not null,
	cidade varchar(100),
	cep varchar(9),
	logradouro varchar(100),
	numero varchar(20),
	complemento varchar(60),
	bairro varchar(60),	
	primary key (id)
) engine=InnoDB default charset=utf8;

alter table contato add constraint fk_contato_restaurante
foreign key (restaurante_id) references restaurante (id);

alter table endereco add constraint fk_endereco_restaurante
foreign key (restaurante_id) references restaurante (id);

