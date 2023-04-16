package com.example.homework_jdbc.dao;

import com.example.homework_jdbc.model.Course;
import com.example.homework_jdbc.model.Grade;
import com.example.homework_jdbc.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GradeDao {
    private JdbcTemplate jdbcTemplate;

    public GradeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Grade> getGradesWithStudentAndCourseInfo() {
        String sql = "SELECT g.id, g.mark, s.id as student_id, s.name as student_name, s.gruppa as student_gruppa, c.id as course_id, c.course_name as course_name FROM GRADES g INNER JOIN STUDENTS s ON g.student_id = s.id INNER JOIN COURSES c ON g.course_id = c.id";
        return jdbcTemplate.query(sql, new GradeWithStudentAndCourseInfoRowMapper());
    }

    private static final class GradeWithStudentAndCourseInfoRowMapper implements RowMapper<Grade> {
        @Override
        public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {

            Grade grade = new Grade();
            grade.setId(rs.getLong("id"));
            grade.setMark(rs.getInt("mark"));

            Student student = new Student();
            student.setId(rs.getLong("student_id"));
            student.setName(rs.getString("student_name"));
            student.setGruppa(rs.getString("student_gruppa"));

            Course course = new Course();
            course.setId(rs.getLong("course_id"));
            course.setCourse_name(rs.getString("course_name"));

            grade.setStudent(student);
            grade.setCourse(course);

            return grade;
        }
    }
}
