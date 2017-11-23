create table midia(
	id int not null auto_increment,
    tipo varchar(255) not null,
    primary key(id)
);

create table gravadora(
	id int not null auto_increment,
    nome varchar(255),
    cnpj double,
    Primary key(id)
);

create table genero(
	id int not null auto_increment,
	tipo varchar(255),
    descricao varchar(255),
    primary key (id)
);

create table artista(
	id int  NOT NULL auto_increment,
	nome varchar(255) not null,
	id_genero int,
    ano_formacao int,
    Primary key(id),
    foreign key(id_genero) references genero(id)
);

CREATE table album(
	id int not null auto_increment,
	nome varchar(255) NOT NULL,
	qtd_musicas int,
	id_artista int,
    id_genero int,
    id_gravadora int,
    Primary key(id),
    foreign key(id_genero) references genero(id),
    foreign key(id_artista) references artista(id),
    foreign key(id_gravadora) references gravadora(id)
);

create table album_midia(
	id_midia int ,
    id_album int ,
    foreign key (id_midia) references midia(id),
    foreign key (id_album) references album(id),
	primary key (id_midia, id_album)
);