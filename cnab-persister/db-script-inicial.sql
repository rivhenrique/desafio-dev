create table transaction_type
(
    type_id numeric not null constraint pk_transaction_type_id primary key,
    description varchar(50),
    nature  varchar(20),
    signal  numeric check ( signal in (0,1) )
);

insert into transaction_type values (1, 'Débito', 'Entrada', 1);
insert into transaction_type values (2, 'Boleto', 'Saída', 0);
insert into transaction_type values (3, 'Financiamento', 'Saída', 0);
insert into transaction_type values (4, 'Crédito', 'Entrada', 1);
insert into transaction_type values (5, 'Recebimento Empréstimo', 'Entrada', 1);
insert into transaction_type values (6, 'Vendas', 'Entrada', 1);
insert into transaction_type values (7, 'Recebimento TED', 'Entrada', 1);
insert into transaction_type values (8, 'Recebimento DOC', 'Entrada', 1);
insert into transaction_type values (9, 'Aluguel', 'Saída', 0);

create sequence seq_id_transaction;

create table transaction
(
    transaction_id numeric default nextval('seq_id_transaction'::regclass) not null
        constraint pk_transaction_id primary key,
    type_id numeric not null constraint transaction_type_fk_type references transaction_type(type_id),
    amount numeric(19,2),
    date_time timestamp,
    document varchar(11),
    card_number varchar(12),
    store_owner_name varchar(14),
    store_name varchar(19)
);