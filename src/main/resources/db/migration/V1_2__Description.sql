CREATE TABLE `category_expenses` (
  `category_category_id` int(11) NOT NULL,
  `expenses_id` int(11) NOT NULL,
  UNIQUE KEY `UK_hgm9775r5b9jaanwl3mabexw5` (`expenses_id`),
  KEY `FKdw3xst4jv9gge7jhvt50sd3m7` (`category_category_id`),
  CONSTRAINT `FKcyg2o95t988vge98srccfal8h` FOREIGN KEY (`expenses_id`) REFERENCES `expense` (`id`),
  CONSTRAINT `FKdw3xst4jv9gge7jhvt50sd3m7` FOREIGN KEY (`category_category_id`) REFERENCES `category` (`category_id`)
) 