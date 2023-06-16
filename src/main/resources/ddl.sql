create table categoria (id bigint generated by default as identity, nome varchar(255) not null, primary key (id))
create table cliente (id bigint generated by default as identity, cpf bigint not null, email varchar(255) not null, nome varchar(255) not null, primary key (id))
create table item_pedido (id bigint generated by default as identity, preco_total decimal(19,2), quantidade integer, pedido_id bigint not null, produto_id bigint not null, primary key (id))
create table pagamento (id bigint generated by default as identity, primary key (id))
create table pedido (id bigint generated by default as identity, data_cancelamento timestamp, data_finalizacao timestamp, data_solicitacao timestamp, status varchar(255), valor decimal(19,2), cliente_id bigint not null, tipo_pagamento_id bigint not null, primary key (id))
create table produto (id bigint generated by default as identity, descricao varchar(255) not null, imagem varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, categoria_id bigint not null, primary key (id))
create table tipo_pagamento (id bigint generated by default as identity, nome varchar(255) not null, primary key (id))
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto
alter table pedido add constraint FK30s8j2ktpay6of18lbyqn3632 foreign key (cliente_id) references cliente
alter table pedido add constraint FK5juq0l4n7h25dly1nwbyqoru0 foreign key (tipo_pagamento_id) references tipo_pagamento
alter table produto add constraint FKopu9jggwnamfv0c8k2ri3kx0a foreign key (categoria_id) references categoria
