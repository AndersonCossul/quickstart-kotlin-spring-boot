CREATE TABLE public.answer (
	id SERIAL,
	message varchar(300) NOT NULL,
	author_id int8 NOT NULL,
	topic_id int8 NOT NULL,
	solves bool NOT NULL,
	created_at timestamp NOT NULL,
	CONSTRAINT answer_pk PRIMARY KEY (id),
	CONSTRAINT answer_fk FOREIGN KEY (id) REFERENCES public.topic(id),
	CONSTRAINT answer_fk_1 FOREIGN KEY (id) REFERENCES public.author(id)
);