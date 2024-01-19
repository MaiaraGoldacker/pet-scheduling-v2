CREATE TABLE schedule
(   id                 bigserial not null,
	start_schedule TIMESTAMP not null,
	end_schedule   TIMESTAMP not null,
    create_date    TIMESTAMP not null DEFAULT Now(),
	clinic_id      BIGINT not null,
	pet_id 		   BIGINT not null,
    CONSTRAINT schedule_pk PRIMARY KEY (id),
	FOREIGN KEY (clinic_id) REFERENCES clinic(id),
	FOREIGN KEY (pet_id) REFERENCES pet (id)
);
