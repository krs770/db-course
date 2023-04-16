package com.example.homework_hibernate.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GRADES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int mark;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    public Grade(int mark, Student student, Course course) {
        this.mark = mark;
        this.student = student;
        this.course = course;
    }
}
