create table orgers
(
    id          bigserial
        constraint orgers_pk
            primary key,
    cost        integer not null,
    description varchar(100)
);