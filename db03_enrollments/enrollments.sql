-- CS3810 - Principles of Database Systems - Spring 2021
-- Instructor: Thyago Mota
-- Description: enrollments database
-- Student(s) Name(s):

DROP DATABASE enrollments;
CREATE DATABASE enrollments;
USE enrollments;

CREATE TABLE courses (
    code       VARCHAR(7)  NOT NULL PRIMARY KEY,
    title      VARCHAR(35) NOT NULL,
    instructor VARCHAR(15) NOT NULL,
    `max`      INT         NOT NULL,
    actual     INT         DEFAULT 0,
    CHECK (actual >= 0 AND actual <= `max`)
);

INSERT INTO courses (code, title, instructor, `max`) VALUES ('CS1030', 'Computer Science Principles',    'Jody Paul',     5);
INSERT INTO courses (code, title, instructor, `max`) VALUES ('CS1050', 'Computer Science 1',             'David Kramer',  3);
INSERT INTO courses (code, title, instructor, `max`) VALUES ('CS2050', 'Computer Science 2',             'Steve Geinitz', 3);
INSERT INTO courses (code, title, instructor, `max`) VALUES ('CS3810', 'Principles of Database Systems', 'Thyago Mota',   2);

CREATE TABLE students (
    id   INT         NOT NULL PRIMARY KEY,
    name VARCHAR(15) NOT NULL
);

INSERT INTO students VALUES ( 1, 'Perry Rhodan' );
INSERT INTO students VALUES ( 2, 'Icho Tolot');
INSERT INTO students VALUES ( 3, 'Deshan Apian');

CREATE TABLE enrollments (
    code VARCHAR(10) NOT NULL,
    id   INT         NOT NULL,
    PRIMARY KEY (code, id),
    FOREIGN KEY (code) REFERENCES courses(code),
    FOREIGN KEY (id)   REFERENCES students(id)
);

-- TODO: create a trigger name enroll_student that automatically increments the actual field in courses whenever a student enrolls in a course

-- TODO: create a trigger name drop_student that automatically decrements the actual field in courses whenever a student drops from a course

-- TODO: create a stored procedure name list_students that returns a list of ids and names of all students currently enrolled in a given course 

CREATE USER 'enrollments' IDENTIFIED BY '135791';
GRANT ALL ON enrollments.* TO 'enrollments';
