CREATE DATABASE IF NOT EXISTS reservation_system;
USE reservation_system;

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS trains (
    train_number INT PRIMARY KEY,
    train_name VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS reservations (
    pnr VARCHAR(20) PRIMARY KEY,
    passenger_name VARCHAR(100) NOT NULL,
    train_number INT NOT NULL,
    class_type VARCHAR(30) NOT NULL,
    journey_date DATE NOT NULL,
    source_station VARCHAR(100) NOT NULL,
    destination_station VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_reservation_train
        FOREIGN KEY (train_number) REFERENCES trains(train_number)
);

INSERT INTO users (username, password)
VALUES ('admin', 'admin123')
ON DUPLICATE KEY UPDATE username = username;

INSERT INTO trains (train_number, train_name) VALUES
(12109, 'Panchavati Express'),
(12110, 'Panchavati Express'),
(12125, 'Pragati Express'),
(12126, 'Pragati Express'),
(12219, 'Secunderabad Duronto Express'),
(12220, 'Secunderabad Duronto Express'),
(11010, 'Sinhagad Express'),
(11011, 'Sinhagad Express')
ON DUPLICATE KEY UPDATE train_name = VALUES(train_name);