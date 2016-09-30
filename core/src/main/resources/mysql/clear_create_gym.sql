
delimiter $$


DROP DATABASE `gym`$$
CREATE DATABASE `gym`$$
USE `gym`$$

CREATE TABLE `user` (
  `user_id` INT (11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (1000) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE `program_template` (
  `program_template_id` INT (11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (1000) NOT NULL,
  `description` VARCHAR (10000),
  `note` VARCHAR (10000),
  PRIMARY KEY (`program_template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE `exercise_template` (
  `exercise_template_id` INT (11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (1000) NOT NULL,
  `description` VARCHAR (10000),
  `note` VARCHAR (10000),
  PRIMARY KEY (`exercise_template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE `program_exercise_templates` (
  `program_exercise_template_id` INT (11) NOT NULL AUTO_INCREMENT,
  `program_template_id` INT (11) NOT NULL,
  `exercise_template_id` INT (11) NOT NULL,
  PRIMARY KEY (`program_exercise_template_id`),
  KEY `fk_program_template` (`program_template_id`),
  KEY `fk_exercise_template` (`exercise_template_id`),
  CONSTRAINT `fk_program_template` FOREIGN KEY (`program_template_id`) REFERENCES `program_template` (`program_template_id`),
  CONSTRAINT `fk_exercise_template` FOREIGN KEY (`exercise_template_id`) REFERENCES `exercise_template` (`exercise_template_id`)
) DEFAULT CHARSET=utf8$$

CREATE TABLE `exercise` (
  `exercise_id` INT (11) NOT NULL AUTO_INCREMENT,
  `program_id` INT (11) NOT NULL,
  `exercise_template_id` INT (11) NOT NULL,
  `name` VARCHAR (1000) NOT NULL,
  `description` VARCHAR (10000),
  `note` VARCHAR (10000),
  PRIMARY KEY (`exercise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE `program` (
  `program_id` INT (11) NOT NULL AUTO_INCREMENT,
  `user_id` INT (11) NOT NULL,
  `name` VARCHAR (1000) NOT NULL,
  `description` VARCHAR (10000),
  `note` VARCHAR (10000),
  `date` DATE NOT NULL,
  PRIMARY KEY (`program_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE `approach` (
  `approach_id` INT (11) NOT NULL AUTO_INCREMENT,
  `exercise_id` INT (11) NOT NULL,
  `times` INT (5),
  `weight` INT (7),
  `measure` VARCHAR (20),
  PRIMARY KEY (`approach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$







