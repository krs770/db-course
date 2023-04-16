package com.example.homework_jpa_liquebase.repository;

import com.example.homework_jpa_liquebase.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    @Query("SELECT NEW Result (g.course.courseName,g.student.gruppa, AVG(g.mark)) FROM Grade g JOIN Student s on g.student = s " +
            "JOIN Course c on g.course = c GROUP BY  g.course.courseName,g.student.gruppa")
    List<Result> getResult();
}
