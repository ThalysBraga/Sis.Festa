create database banco_projeto_ds;
use banco_projeto_ds;

create table Cliente (
id_cli int not null auto_increment primary key,
cpf_cnpj_cli varchar (20) not null,
telefone_cli varchar (15) not null,
cep_cli varchar (9),
enderoco_cli varchar (300) not null,
nome_cli varchar (100) not null
);

create table FuncionarioUsuario (
id_fun int auto_increment not null primary key,
nome_fun varchar (100) not null,
senha_fun varchar (10) not null,
cargo_fun varchar (15) not null,
telefone_fun varchar (15) not null,
endereco_fun varchar (300) not null,
cpf_fun varchar (15) not null,
data_nasc_fun datetime
);

create table Produto (
id_pro int not null auto_increment primary key,
nome_pro varchar (100) not null,
preco_pro float not null,
descricao_pro varchar (600) not null
);

create table Venda (
id_ven int not null auto_increment primary key,
preco_total_ven float not null,
forma_pagamento_ven varchar (5),
id_cli int,
id_fun int,
foreign key (id_cli) references Cliente (id_cli), 
foreign key (id_fun) references FuncionarioUsuario (id_fun)
);

create table Venda_Produto (
id_ven_pro int not null auto_increment primary key,
id_pro int,
id_ven int,
quant_pro int,
foreign key (id_pro) references Produto (id_pro),
foreign key (id_ven) references Venda (id_ven)
);

create table Recebimento (
id_rec int not null auto_increment primary key,
data_rec datetime,
valor_rec float not null,
id_ven int,
foreign key (id_ven) references Venda (id_ven)
);

create table Ingrediente (
id_ing int not null auto_increment primary key,
nome_ing varchar (100),
preco_medio_ing float not null
);

create table Estoque (
id_est int not null auto_increment primary key,
preco_est float not null,
data_validade_estoque datetime,
quant_estpque int not null,
id_ing int,
foreign key (id_ing) references Ingrediente (id_ing)
);

create table Despesa (
id_desp int not null auto_increment primary key,
valor_desp float not null,
valor_pag_desp float not null,
nome_desp varchar (100)
);