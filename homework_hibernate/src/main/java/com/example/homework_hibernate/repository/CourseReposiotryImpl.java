package com.example.homework_hibernate.repository;

import com.example.homework_hibernate.models.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseReposiotryImpl implements CourseRepository {

    @PersistenceContext
    private final EntityManager em;

    public CourseReposiotryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Course save(Course course) {
        if (course.getId() <= 0) {
            em.persist(course);
            return course;
        } else {
            return em.merge(course);
        }
    }
}
