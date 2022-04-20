create database test DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'test'@'localhost' IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON test.* TO 'test'@'localhost';

use test;

CREATE TABLE test1( 
    id TINYINT ZEROFILL NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY(id));

INSERT INTO `test1`(`name`) VALUES ("test1");
INSERT INTO `test1`(`name`) VALUES ("test2");
INSERT INTO `test1`(`name`) VALUES ("test3");
INSERT INTO `test1`(`name`) VALUES ("test4");