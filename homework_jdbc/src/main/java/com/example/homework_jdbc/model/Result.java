package com.example.homework_jdbc.model;

import lombok.Data;

@Data
public class Result {

    private String course_name;
    private String gruppa;
    private double mark;

    @Override
    public String toString() {
        return  "course_name='" + course_name + '\'' +
                ", gruppa='" + gruppa + '\'' +
                ", mark=" + mark + "\n";
    }
}
