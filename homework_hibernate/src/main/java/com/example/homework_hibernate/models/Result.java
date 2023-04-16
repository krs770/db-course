package com.example.homework_hibernate.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String courseName;

    private String gruppa;

    private double mark;

    public Result(String courseName, String gruppa, double mark) {
        this.courseName = courseName;
        this.gruppa = gruppa;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "courseName='" + courseName + '\'' +
                ", gruppa='" + gruppa + '\'' +
                ", mark=" + mark + '\n';
    }
}
