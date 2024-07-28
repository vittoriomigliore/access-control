CREATE TABLE USERS
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(50)  NOT NULL
);

CREATE TABLE GATES_LOGS
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id   BIGINT      NOT NULL,
    type      VARCHAR(50) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES USERS (id)
);