
delimiter $$


DROP DATABASE `test1`$$
CREATE DATABASE `test1`$$
USE `test1`$$


CREATE TABLE `owner` (
  `owner_id` INT (11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (50) NOT NULL,
  `registration_date` DATE,
  PRIMARY KEY (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE `training` (
  `training_id` INT (11) NOT NULL AUTO_INCREMENT,
  `owner_id` INT (11) NOT NULL,
  `date` DATE NOT NULL ,
  `status` VARCHAR (50) NOT NULL,
  `user_weight` DECIMAL,
  `start_training_time` TIME,
  `end_training_time` TIME,
  `note` VARCHAR (500),
  `summary_training_weight` DECIMAL,
  PRIMARY KEY (`training_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$


CREATE TABLE `exercise` (
  `exercise_id` INT (11) NOT NULL AUTO_INCREMENT,
  `training_id` INT (11) NOT NULL,
  `exercise_type_id` INT (11) NOT NULL,
  `exercise_load` VARCHAR (50),
  `note` VARCHAR (500),
  PRIMARY KEY (`exercise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE `attempt` (
  `attempt_id` INT (11) NOT NULL AUTO_INCREMENT,
  `exercise_id` INT (11) NOT NULL,
  `actual_weight` DECIMAL,
  `estimate_weight` DECIMAL,
  `actual_times` INT (11),
  `estimate_times` INT (11),
  `note` VARCHAR (500),
  PRIMARY KEY (`attempt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE `program` (
  `program_id` INT (11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (100),
  `description` VARCHAR (500),
  `note` VARCHAR (500),
  `order_number` INT (11),
  PRIMARY KEY (`program_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

CREATE TABLE `exercise_type` (
  `exercise_type_id` INT (11) NOT NULL AUTO_INCREMENT,
  `program_id` INT (11) NOT NULL,
  `name` VARCHAR (100),
  `description` VARCHAR (500),
  `note` VARCHAR (500),
  `picture` VARCHAR (100),
  `order_number` INT (11),
  PRIMARY KEY (`exercise_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$



