SET NAMES 'utf8' COLLATE 'utf8_general_ci';

DROP DATABASE IF EXISTS `bfa`;

CREATE DATABASE `bfa` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `bfa`;

CREATE TABLE `garage` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` TEXT NOT NULL,
    `city` TEXT NOT NULL,
    `maxCapacity` INT NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE car (
    `id` INT NOT NULL AUTO_INCREMENT,
    `color` TEXT NOT NULL,
    `year` INT NOT NULL,
    `brand` TEXT NOT NULL,
    `garageId` INT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`garageId`) REFERENCES garage(id)
);

INSERT INTO `garage`(name, city, maxCapacity)
    VALUES('John garage', 'Miskolc', 2);

INSERT INTO `garage`(name, city, maxCapacity)
VALUES('Misi garage', 'Encs', 1);

INSERT INTO `garage`(name, city, maxCapacity)
VALUES('Will garage', 'Felsőzsolca', 3);

INSERT INTO `car`(color, year, brand, garageId)
VALUES('blue', 2009, 'Suzuki', 1);

INSERT INTO `car`(color, year, brand, garageId)
VALUES('white', 2005, 'Fiat', 1);

INSERT INTO `car`(color, year, brand, garageId)
VALUES('black', 2009, 'Saab', 2);

INSERT INTO `car`
VALUES(NULL, 'grey', 2007, 'Mercedes', 3);
INSERT INTO `car` VALUES (NULL, 'red', 2005, 'BMW', 3);
INSERT INTO `car` VALUES (NULL, 'white', 2000, 'Opel', 3);





