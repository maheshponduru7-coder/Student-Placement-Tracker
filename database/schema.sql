CREATE DATABASE IF NOT EXISTS student_placement_tracker;

USE student_placement_tracker;

CREATE TABLE IF NOT EXISTS problems (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    difficulty VARCHAR(20) NOT NULL,
    company VARCHAR(50) NOT NULL,
    topic VARCHAR(50) NOT NULL,
    solved BOOLEAN DEFAULT FALSE
);

