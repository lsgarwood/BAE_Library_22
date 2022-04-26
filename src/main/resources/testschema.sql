DROP TABLE IF EXISTS book CASCADE;
CREATE TABLE book (
	id INT AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	author VARCHAR(255) NOT NULL,
	genre VARCHAR(255) UNIQUE NOT NULL,
	available BOOLEAN,
	primary key (id)
);