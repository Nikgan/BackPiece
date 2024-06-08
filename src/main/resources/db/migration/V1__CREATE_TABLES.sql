CREATE TABLE `sport` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `sport_name` varchar(255) NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `sport_name` (`sport_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `sport` VALUES (1,'Лыжный');

CREATE TABLE `users` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `password` varchar(255) DEFAULT NULL,
                         `role` varchar(255) DEFAULT NULL,
                         `username` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` VALUES (1,'$2a$10$WgqC86U.7fj.DylBKVhiSexuw5PiNaVIVtthbsqp8ctcriLxyC33m','USER','Nikita'),(3,'$2a$10$narA5ILfv8wOOUqnYcX6uOILf5ErqtPMD9mQsuW.gotd7QH8lsSse','ADMIN,USER','Admin'),(4,'$2a$10$GGaReb9qks.DJzoxyZfJN.ukjWOLPxKcQhtRbYF9tSZBViNQCNZAq','ADMIN,USER','Administrator');

CREATE TABLE if not exists `criteria` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `sport_id` bigint DEFAULT NULL,
                            `criterion_name` varchar(255) NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `criterion_name` (`criterion_name`),
                            KEY `sport_id` (`sport_id`),
                            CONSTRAINT `criteria_ibfk_1` FOREIGN KEY (`sport_id`) REFERENCES `sport` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `criteria` VALUES (1,1,'Красивовость'),(2,1,'Правильновость');

CREATE TABLE if not exists `participant` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `surname` varchar(255) NOT NULL,
                               `name` varchar(255) NOT NULL,
                               `middle_name` varchar(255) DEFAULT NULL,
                               `sport_id` bigint DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               KEY `sport_id` (`sport_id`),
                               CONSTRAINT `participant_ibfk_1` FOREIGN KEY (`sport_id`) REFERENCES `sport` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `participant` VALUES (2,'Васин','Игорь','Дмитриевич',1),(3,'Алышева','Алиса','Сергеевна',1);

CREATE TABLE `score` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `participant_id` bigint DEFAULT NULL,
                         `criterion_id` bigint DEFAULT NULL,
                         `score` double NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `participant_id` (`participant_id`),
                         KEY `criterion_id` (`criterion_id`),
                         CONSTRAINT `score_ibfk_1` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`),
                         CONSTRAINT `score_ibfk_2` FOREIGN KEY (`criterion_id`) REFERENCES `criteria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
