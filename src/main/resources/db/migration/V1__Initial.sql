CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
);


CREATE TABLE `expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmvjm59reb5i075vu38bwcaqj6` (`category_id`),
  CONSTRAINT `FKmvjm59reb5i075vu38bwcaqj6` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
);



