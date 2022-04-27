DROP TABLE IF EXISTS book CASCADE;
CREATE TABLE book (
	id INT INCREMENT(20325,5),
	author VARCHAR(255) NOT NULL,
	available BOOLEAN,
	genre VARCHAR(255) NOT NULL,
	title VARCHAR(255) NOT NULL,
	image_link VARCHAR(255),
	review VARCHAR(255),
	primary key (id)
);