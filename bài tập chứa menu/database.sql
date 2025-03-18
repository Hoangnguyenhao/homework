CREATE DATABASE FormDB;
USE FormDB;

DROP TABLE IF EXISTS UserInput;

CREATE TABLE UserInput (
    id INT PRIMARY KEY IDENTITY(1,1),
    input_text TEXT NOT NULL,
    created_at DATETIME DEFAULT GETDATE()
);

INSERT INTO UserInput (input_text) VALUES ('Test Data');
