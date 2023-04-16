package com.example.homework_hibernate;

import com.example.homework_hibernate.models.Course;
import com.example.homework_hibernate.models.Grade;
import com.example.homework_hibernate.models.Student;
import com.example.homework_hibernate.repository.*;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class HomeworkHibernateApplication {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = SpringApplication.run(HomeworkHibernateApplication.class);


        StudentRepository daoStudent = context.getBean(StudentRepositoryImpl.class);
        CourseRepository daoCourse = context.getBean(CourseReposiotryImpl.class);
        GradeRepository daoGrade = context.getBean(GradeRepositoryImpl.class);
        ResultRepository daoResult = context.getBean(ResultRepository.class);

        Student student1 = new Student("aleksey", "e-02");
        Student student2 = new Student("sergey", "e-03");
        Student student3 = new Student("dasha", "e-02");
        Student student4 = new Student("igor", "e-03");

        Course course1 = new Course("java");
        Course course2 = new Course("math");

        Grade grade = new Grade(5, student1, course1);
        Grade grade1 = new Grade(3, student1, course2);
        Grade grade3 = new Grade(4, student2, course1);
        Grade grade4 = new Grade(2, student2, course2);
        Grade grade5 = new Grade(3, student3, course1);
        Grade grade6 = new Grade(5, student3, course2);
        Grade grade7 = new Grade(2, student4, course1);
        Grade grade8 = new Grade(5, student4, course2);

        daoStudent.save(student1);
        daoStudent.save(student2);
        daoStudent.save(student3);
        daoStudent.save(student4);

        daoCourse.save(course1);
        daoCourse.save(course2);

        daoGrade.save(grade);
        daoGrade.save(grade1);
        daoGrade.save(grade3);
        daoGrade.save(grade4);
        daoGrade.save(grade5);
        daoGrade.save(grade6);
        daoGrade.save(grade7);
        daoGrade.save(grade8);

        System.out.println(daoResult.getResult());


        Console.main(args);
    }

}
