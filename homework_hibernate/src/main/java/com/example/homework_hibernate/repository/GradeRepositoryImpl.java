package com.example.homework_hibernate.repository;

import com.example.homework_hibernate.models.Grade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GradeRepositoryImpl implements GradeRepository {

    @PersistenceContext
    private final EntityManager em;

    public GradeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Grade save(Grade grade) {
        if (grade.getId() <= 0) {
            em.persist(grade);
            return grade;
        } else {
            return em.merge(grade);
        }
    }
}
