CREATE TABLE students (
      id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
      fname VARCHAR(100) NOT NULL,
      lname VARCHAR(100) NOT NULL,
      email VARCHAR(100) NOT NULL UNIQUE,
      phone VARCHAR(100) NOT NULL,
      username VARCHAR(100) NOT NULL UNIQUE,
      town VARCHAR(100) NOT NULL,
      hobby TEXT
);

CREATE TABLE courses (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    yhp INT NOT NULL
);

CREATE TABLE attendance (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT NOT NULL REFERENCES students(id),
    course_id BIGINT NOT NULL REFERENCES courses(id)
);
ALTER TABLE attendance ADD CONSTRAINT unique_combo_att UNIQUE (student_id, course_id);

INSERT INTO courses (name, description, yhp) VALUES ('Programmering 101', 'Learn to program in C#', 100);
INSERT INTO courses (name, description, yhp) VALUES ('Programmering 102', 'Learn to program in Java#', 100);
INSERT INTO courses (name, description, yhp) VALUES ('English', 'Learn engrish', 50);
INSERT INTO courses (name, description, yhp) VALUES ('Polish', 'Learn polska', 50);
INSERT INTO courses (name, description, yhp) VALUES ('Rust', 'Learn hardcore rust', 75);

INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Max', 'Malmö', 'Programming', 'Max', 'Ulfson', 'linus@gmail.com', '012375456');
INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Maria', 'Malmö', 'Gaming', 'Maria', 'Lundberg', 'maria@gmail.com', '01244506a');
INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Sara', 'Helsingborg', 'Gym', 'Sara', 'Tveit', 'sara@gmail.com', '012345655');
INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Bob', 'Lund', 'Gym', 'Bob', 'Sob', 'bob@gmail.com', '123456');
INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Zob', 'Lund', null, 'Aob', 'Eob', 'zob@gmail.com', '1234567');
INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Pete', 'Lund', 'Badminton', 'Pete', 'Marchal', 'pete@gmail.com', '0183456');
INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Adm11', 'Stockholm', 'Guns', 'Adam', 'Apple', 'adm11@gmail.com', '011345609');
INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Adm12', 'Stockholm', 'Guns', 'Adam', 'Olofson', 'adm12@gmail.com', '0133456');
INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Halla', 'Stockholm', 'Programming', 'Hal', 'Petersson', 'halla@gmail.com', '01234456');
INSERT INTO students (username, town, hobby, fname, lname, email, phone) VALUES ('Emil', 'Stockholm', 'Programming', 'Emil', 'Olofson', 'emil@gmail.com', '012343566');

INSERT INTO attendance (student_id, course_id) VALUES (1,1);
INSERT INTO attendance (student_id, course_id) VALUES (1,2);
INSERT INTO attendance (student_id, course_id) VALUES (2,1);
INSERT INTO attendance (student_id, course_id) VALUES (3,1);
INSERT INTO attendance (student_id, course_id) VALUES (4,3);
INSERT INTO attendance (student_id, course_id) VALUES (5,3);
INSERT INTO attendance (student_id, course_id) VALUES (6,4);
INSERT INTO attendance (student_id, course_id) VALUES (7,4);
INSERT INTO attendance (student_id, course_id) VALUES (8,4);
INSERT INTO attendance (student_id, course_id) VALUES (8,5);