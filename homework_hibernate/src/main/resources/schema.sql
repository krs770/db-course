DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS grades;
DROP TABLE IF EXISTS courses;

create table courses
(
    id   bigserial,
    course_name varchar(255),
    primary key (id)
);

create table students
(
    id     bigserial,
    name   varchar(255),
    gruppa varchar(255),
    primary key (id)
);

create table grades
(
    id         bigserial,
    mark       int,
    student_id bigint references students(id),
    course_id bigint references courses(id),
    primary key (id)
);