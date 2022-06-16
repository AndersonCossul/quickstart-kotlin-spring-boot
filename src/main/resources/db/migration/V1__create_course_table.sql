CREATE TABLE public.course (
	id SERIAL,
	"name" varchar(50) NOT NULL,
	category varchar(50) NOT NULL,
	CONSTRAINT course_pkey PRIMARY KEY (id)
);

INSERT INTO course VALUES(1, 'Kotlin', 'Programming');