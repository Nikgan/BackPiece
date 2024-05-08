CREATE TABLE if not exists sport (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        sport_name VARCHAR(255) NOT NULL unique
);

CREATE TABLE if not exists participant (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              surname VARCHAR(255) NOT NULL,
                              name VARCHAR(255) NOT NULL,
                              middle_name VARCHAR(255),
                              sport_id BIGINT,
                              FOREIGN KEY (sport_id) REFERENCES sport(id)
);

CREATE TABLE if not exists criteria (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          sport_id BIGINT,
                          criterion_name VARCHAR(255) NOT NULL unique ,
                          FOREIGN KEY (sport_id) REFERENCES sport(id)
);

CREATE TABLE if not exists score (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        participant_id BIGINT,
                        criterion_id BIGINT,
                        score INT,
                        FOREIGN KEY (participant_id) REFERENCES participant(id),
                        FOREIGN KEY (criterion_id) REFERENCES criteria(id)
);