
delimiter $$

DROP DATABASE `gym_test`$$
CREATE DATABASE `gym_test`$$
USE `gym_test`$$

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` INT (11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (1000) NOT NULL,
  `login` VARCHAR (1000) NOT NULL,
  `password` VARCHAR (60) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `username` VARCHAR(64) NOT NULL,
  `series` VARCHAR(64) NOT NULL,
  `token` VARCHAR(64) NOT NULL,
  `last_used` TIMESTAMP NOT NULL,
  PRIMARY KEY (`series`)
) DEFAULT CHARSET=utf8$$;

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` INT (11) NOT NULL AUTO_INCREMENT,
  `user_id` INT (11) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  KEY `fk_user` (`user_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE IF NOT EXISTS `program_template` (
  `program_template_id` INT (11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (1000) NOT NULL,
  `description` VARCHAR (10000),
  `note` VARCHAR (10000),
  PRIMARY KEY (`program_template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE IF NOT EXISTS `exercise_template` (
  `exercise_template_id` INT (11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (1000) NOT NULL,
  `description` VARCHAR (10000),
  `note` VARCHAR (10000),
  PRIMARY KEY (`exercise_template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE IF NOT EXISTS `program_exercise_templates` (
  `program_exercise_template_id` INT (11) NOT NULL AUTO_INCREMENT,
  `program_template_id` INT (11) NOT NULL,
  `exercise_template_id` INT (11) NOT NULL,
  PRIMARY KEY (`program_exercise_template_id`),
  KEY `fk_program_template` (`program_template_id`),
  KEY `fk_exercise_template` (`exercise_template_id`),
  CONSTRAINT `fk_program_template` FOREIGN KEY (`program_template_id`) REFERENCES `program_template` (`program_template_id`),
  CONSTRAINT `fk_exercise_template` FOREIGN KEY (`exercise_template_id`) REFERENCES `exercise_template` (`exercise_template_id`)
) DEFAULT CHARSET=utf8$$

CREATE TABLE IF NOT EXISTS `exercise` (
  `exercise_id` INT (11) NOT NULL AUTO_INCREMENT,
  `program_id` INT (11) NOT NULL,
  `exercise_template_id` INT (11) NOT NULL,
  `name` VARCHAR (1000) NOT NULL,
  `description` VARCHAR (10000),
  `note` VARCHAR (10000),
  PRIMARY KEY (`exercise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE IF NOT EXISTS `program` (
  `program_id` INT (11) NOT NULL AUTO_INCREMENT,
  `user_id` INT (11) NOT NULL,
  `name` VARCHAR (1000) NOT NULL,
  `description` VARCHAR (10000),
  `note` VARCHAR (10000),
  `date` DATE NOT NULL,
  PRIMARY KEY (`program_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE IF NOT EXISTS `approach` (
  `approach_id` INT (11) NOT NULL AUTO_INCREMENT,
  `exercise_id` INT (11) NOT NULL,
  `times` INT (5),
  `weight` INT (7),
  `measure` VARCHAR (20),
  PRIMARY KEY (`approach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$





