DROP TABLE IF EXISTS BOOKS;
DROP TABLE IF EXISTS GENRES;
DROP TABLE IF EXISTS AUTHORS;
DROP TABLE IF EXISTS BOOKS_AUTHORS;
DROP TABLE IF EXISTS BOOKS_GENRES;

CREATE TABLE GENRES
(ID_GENRE INT NOT NULL,
GENRE VARCHAR(255) NOT NULL,
PRIMARY KEY(ID_GENRE));

CREATE TABLE AUTHORS
(ID_AUTHOR INT NOT NULL,
PEN_NAME VARCHAR(255) NOT NULL,
PRIMARY KEY(ID_AUTHOR));

CREATE TABLE BOOKS
(ID_BOOK INT NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID_BOOK));

CREATE TABLE BOOKS_AUTHORS
(ID_BOOK INT NOT NULL,
    ID_AUTHOR INT NOT NULL);

CREATE TABLE BOOKS_GENRES
(ID_BOOK INT NOT NULL,
    ID_GENRE INT NOT NULL);