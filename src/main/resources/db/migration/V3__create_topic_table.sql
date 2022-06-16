CREATE TABLE public.topic (
	id SERIAL,
	title varchar(50) NOT NULL,
	message varchar(300) NOT NULL,
	created_at timestamp NOT NULL,
	status varchar(20) NOT NULL,
	course_id int8 NOT NULL,
	author_id int8 NOT NULL,
	CONSTRAINT topic_pkey PRIMARY KEY (id),
	CONSTRAINT topic_author_id_fkey FOREIGN KEY (author_id) REFERENCES public.author(id),
	CONSTRAINT topic_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id)
);