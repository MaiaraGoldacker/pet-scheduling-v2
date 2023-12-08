CREATE TABLE pet
(   id                 bigserial not null,
    name               varchar(255) not null,
    create_date        TIMESTAMP not null DEFAULT Now(),
    birth_date         date not null,
    specie             varchar(50) not null,
    CONSTRAINT pet_pk PRIMARY KEY (id));

