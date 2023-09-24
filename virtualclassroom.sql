-- creating the database and using it
create database Virtual_Classroom;
USE Virtual_Classroom; 

-- creating table classrooms
CREATE TABLE classrooms ( className VARCHAR(255) PRIMARY KEY );

-- creating table students
CREATE TABLE students (
studentId INT PRIMARY KEY,
studentName VARCHAR(255) NOT NULL,
classroom_name VARCHAR(255) NOT NULL,
FOREIGN KEY (classroom_name) REFERENCES classrooms (ClassName) );


-- creating table assignments
CREATE TABLE assignments(
assignmentDetails TEXT,
classroom_name VARCHAR(255) NOT NULL,
FOREIGN KEY (classroom_name) REFERENCES classrooms (ClassName) );


-- creating table submitted_assignments
CREATE TABLE submitted_assignments (student_Id INT NOT NULL,
classroom_name VARCHAR(255) NOT NULL, assignment_details TEXT,
FOREIGN KEY (student_Id) REFERENCES students(studentId), FOREIGN KEY (classroom_name) 
REFERENCES classrooms (ClassName), PRIMARY KEY (student_id, classroom_name));



desc classrooms;
desc students;
desc assignments;
desc submitted_assignments;


-- retrieving data from classrooms
select * from classrooms;


-- retrieving data from students
select * from students;


-- retrieving data from assignments
select * from assignments;


-- retrieving data from submitted_assignments
select * from submitted_assignments;