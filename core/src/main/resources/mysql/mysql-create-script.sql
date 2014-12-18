
CREATE DATABASE `gym`;

CREATE TABLE `program` (
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
  `date` date NOT NULL,
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

CREATE DATABASE `sequence`;

CREATE TABLE `sequence`.`sequence_data` (
  `sequence_name` varchar(50) NOT NULL,
  `sequence_increment` int(11) unsigned NOT NULL DEFAULT 1,
  `sequence_min_value` int(11) unsigned NOT NULL DEFAULT 1,
  `sequence_max_value` int(11) unsigned NOT NULL DEFAULT 2147483647,
  `sequence_cur_value` int(11) unsigned DEFAULT 1,
  `sequence_cycle` boolean NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB;

INSERT INTO sequence.sequence_data
(sequence_name)
  VALUE
  ('order_number_sequence')
;

CREATE FUNCTION `give_order_number` ()
  RETURNS int(11) NOT DETERMINISTIC
  BEGIN
    DECLARE cur_val int(11);

    SELECT
      sequence_cur_value INTO cur_val
    FROM
      sequence.sequence_data
    WHERE
      sequence_name = 'order_number_sequence'
    ;

    IF cur_val IS NOT NULL THEN
      UPDATE
        sequence.sequence_data
      SET
        sequence_cur_value = IF (
            (sequence_cur_value + sequence_increment) > sequence_max_value,
            IF (
                sequence_cycle = TRUE,
                sequence_min_value,
                NULL
            ),
            sequence_cur_value + sequence_increment
        )
      WHERE
        sequence_name = 'order_number_sequence'
      ;
    END IF;

    RETURN cur_val;
  END;





