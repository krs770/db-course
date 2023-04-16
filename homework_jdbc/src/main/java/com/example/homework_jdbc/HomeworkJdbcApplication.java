package com.example.homework_jdbc;

import com.example.homework_jdbc.dao.GradeDao;
import com.example.homework_jdbc.dao.ResultDao;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class HomeworkJdbcApplication {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = SpringApplication.run(HomeworkJdbcApplication.class);

        GradeDao daoGrade = context.getBean(GradeDao.class);
        ResultDao daoResult = context.getBean(ResultDao.class);

//        System.out.println(daoGrade.getGradesWithStudentAndCourseInfo());
        System.out.println(daoResult.getResult());

        Console.main(args);
    }

}
