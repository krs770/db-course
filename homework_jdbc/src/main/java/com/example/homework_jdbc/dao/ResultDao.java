package com.example.homework_jdbc.dao;

import com.example.homework_jdbc.model.Result;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResultDao {

    private JdbcTemplate jdbcTemplate;

    public ResultDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Result> getResult() {
        String sql = "SELECT s.gruppa as student_gruppa, c.course_name as course_name, avg(g.mark) as avg_mark FROM GRADES g INNER JOIN STUDENTS s ON g.student_id = s.id INNER JOIN COURSES c ON g.course_id = c.id GROUP BY student_gruppa,course_name";
        return jdbcTemplate.query(sql, new ResultRowMapper());
    }

    private static final class ResultRowMapper implements RowMapper<Result> {
        @Override
        public Result mapRow(ResultSet rs, int rowNum) throws SQLException {

            Result result = new Result();
            result.setGruppa(rs.getString("student_gruppa"));
            result.setCourse_name(rs.getString("course_name"));
            result.setMark(rs.getDouble("avg_mark"));

            return result;
        }
    }
}
