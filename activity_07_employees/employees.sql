-- employees database
-- created at: <date>
-- author: <your name>

-- TODO: create database employees
CREATE DATABASE employees;

USE employees;

DROP TABLE IF EXISTS Employees;

DROP TABLE IF EXISTS Departments;

-- TODO: create table departments
CREATE TABLE Departments (
  code CHAR(2) PRIMARY KEY,
  `desc` VARCHAR(40) NOT NULL
);

-- TODO: populate table departments

INSERT INTO Departments VALUES
  ( 'HR', 'Human Resources' ),
  ( 'IT', 'Information Technology' ),
  ( 'SL', 'Sales');

-- TODO: create table employees

CREATE TABLE Employees (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  sal  DECIMAL(8, 2) NOT NULL,
  deptCode CHAR(2),
  FOREIGN KEY (deptCode) REFERENCES Departments ( code )
);

-- TODO: populate table Employees

INSERT INTO Employees (name, sal, deptCode) VALUES
  ( 'Sam Mai Tai', 50000, 'HR' );

INSERT INTO Employees (name, sal, deptCode) VALUES
  ( 'James Brandy', 55000, 'HR' );

INSERT INTO Employees (name, sal, deptCode) VALUES
  ('Whisky Strauss', 60000, 'HR'),
  ('Romeo Curacau', 65000, 'IT'),
  ('Jose Caipirinha', 65000, 'IT'),
  ('Tony Gin and Tonic', 80000, 'SL');

INSERT INTO Employees (name, sal, deptCode) VALUES
  ('Debby Derby', 85000, 'SL');

INSERT INTO Employees (name, sal, deptCode) VALUES
  ('Morbid Mojito', 150000, NULL);

-- TODO: a) list all rows in Departments.
SELECT * FROM Department;

-- TODO: b) list only the codes in Departments.
SELECT code FROM Departments;

-- TODO: c) list all rows in Employees.
SELECT * FROM Employees;

-- TODO: d) list only the names in Employees in alphabetical order.
SELECT name FROM Employees ORDER BY 1;

-- TODO: e) list only the names and salaries in Employees, from the highest to the lowest salary.
SELECT name, sal FROM Employees ORDER BY sal DESC;

-- TODO: f) list the cartesian product of Employees and Departments.
SELECT * FROM Employees, Departments;

-- TODO: g) do the natural join of Employees and Departments; the result should be exactly the same as the cartesian product; do you know why?
SELECT * FROM Employees NATURAL JOIN Departments;

-- there wasn't attributes with the same names

-- TODO: i) do an equi join of Employees and Departments matching the rows by Employees.deptCode and Departments.code (hint: use JOIN and the ON clause).
SELECT * FROM Employees INNER JOIN Departments ON deptCode = code;

SELECT * FROM Employees, Departments WHERE deptCode = code;

-- TODO: j) same as previous query but project name and salary of the employees plus the description of their departments.
SELECT A.name, A.sal, B.`desc` FROM Employees A, Departments B WHERE deptCode = code;

-- TODO: k) same as previous query but only the employees that earn less than 60000.
SELECT name, sal, `desc` FROM Employees, Departments WHERE deptCode = code and sal < 60000;

SELECT A.name, A.sal, B.`desc` FROM Employees A, Departments B WHERE deptCode = code AND sal < 60000;

-- TODO: l) same as query ‘i’  but only the employees that earn more than ‘Jose Caipirinha’.

SET @jose_sal = (SELECT sal FROM Employees WHERE name LIKE 'Jose Caipi%');

SELECT * FROM Employees, Departments WHERE deptCode = code AND sal > @jose_sal;

SELECT * FROM Employees, Departments WHERE deptCode = code AND sal > (SELECT sal FROM Employees WHERE name LIKE 'Jose Caipi%');

-- TODO: m) list the left outer join of Employees and Departments (use the ON clause to match by department code); how does the result of this query differs from query ‘i’?
SELECT * FROM Employees A LEFT OUTER JOIN Departments B ON A.deptCode = B.code;

-- TODO: n) from query ‘m’, how would you do the left anti-join?
SELECT * FROM Employees A LEFT OUTER JOIN Departments B ON A.deptCode = B.code WHERE deptCode IS NULL;

-- TODO: o) show the number of employees per department.
SELECT deptCode, COUNT(deptCode) FROM Employees GROUP BY deptCode HAVING deptCode IS NOT NULL;

-- TODO: p) same as query ‘o’ but I want to see the description of each department (not just their codes).
SELECT `desc` AS 'Department Description', COUNT(deptCode) AS 'Total' FROM Employees INNER JOIN Departments ON deptCode = code GROUP BY deptCode HAVING deptCode IS NOT NULL;
