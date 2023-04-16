package com.example.homework_hibernate.repository;

import com.example.homework_hibernate.models.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ResultRepositoryImpl implements ResultRepository {

    @PersistenceContext
    private final EntityManager em;

    public ResultRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Result> getResult() {
        TypedQuery<Result> query = em.createQuery("SELECT NEW Result (g.course.courseName,g.student.gruppa, avg(g.mark)) from Grade g JOIN Student s on g.student = s " +
                "JOIN Course c on g.course = c GROUP BY  g.course.courseName,g.student.gruppa", Result.class);
        return query.getResultList();
    }
}
