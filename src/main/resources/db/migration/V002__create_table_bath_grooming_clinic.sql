CREATE TABLE clinic
(   id                 bigserial not null,
    name               varchar(500) not null,
	cnpj               varchar(25) not null,
	duration	       int4 not null,
    create_date        TIMESTAMP not null DEFAULT Now(),
    CONSTRAINT clinic_pk PRIMARY KEY (id)
);
