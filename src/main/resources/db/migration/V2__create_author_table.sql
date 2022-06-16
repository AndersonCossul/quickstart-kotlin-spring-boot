CREATE TABLE public.author (
	id SERIAL,
	"name" varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	CONSTRAINT author_pkey PRIMARY KEY (id)
);

INSERT INTO author VALUES(1, 'Anderson Cossul', 'anderson.cossul@softdesign.com.br');