
delimiter $$

CREATE DATABASE `test1`$$
USE `test1`$$

/*CREATE TABLE `program` (
  `program_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(500),
  `order_number` int(11) NOT NULL,
  PRIMARY KEY (`program_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `workout` (
  `workout_id` int(11) NOT NULL AUTO_INCREMENT,
  `program_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(500),
  `picture_id` int(11),
  `order_number` int(11) NOT NULL,
  PRIMARY KEY (`workout_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `exercise` (
  `exercise_id` int(11) NOT NULL AUTO_INCREMENT,
  `workout_id` int(11) NOT NULL,
  `type_of_exercise` varchar(20),
  PRIMARY KEY (`exercise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `attempt` (
  `attempt_id` int(11) NOT NULL AUTO_INCREMENT,
  `exercise_id` int(11) NOT NULL,
  `weight` decimal NOT NULL,
  `times` int(3) NOT NULL,
  PRIMARY KEY (`attempt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
*/

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



