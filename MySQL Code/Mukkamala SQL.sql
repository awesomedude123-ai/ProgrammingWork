CREATE DATABASE Mukkamala_music;
USE Mukkamala_music;
CREATE TABLE music_basic(
	music_basic_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    song VARCHAR(45) NOT NULL,
    artist VARCHAR(45) NOT NULL,
    genre VARCHAR(20) NOT NULL,
    duration DECIMAL(4,2) NOT NULL DEFAULT 0.00,
    release_date INT NOT NULL DEFAULT 0,
    album VARCHAR(40) NULL
);