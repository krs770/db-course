package com.example.homework_jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private long id;
    private int mark;
    private Student student;
    private Course course;

    @Override
    public String toString() {
        return  "id=" + id +
                ", mark=" + mark +
                ", student=" + student +
                ", course=" + course + "\n";
    }
}
