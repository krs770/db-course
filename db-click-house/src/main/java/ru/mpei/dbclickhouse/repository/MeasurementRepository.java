package ru.mpei.dbclickhouse.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.mpei.dbclickhouse.domain.Measurement;

@Service
@AllArgsConstructor
public class MeasurementRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(Measurement measurement) {
        String sql =
            "insert into measurement.test (source,timestamp,value) " +
            "SETTINGS async_insert=1, wait_for_async_insert=0 " +
            "values (:source, :timestamp, :value);";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("source", measurement.source());
        parameterSource.addValue("timestamp", measurement.timestamp());
        parameterSource.addValue("value", measurement.value());
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    public List<Measurement> findAll() {
        return namedParameterJdbcTemplate.query("select * from measurement.test",
                new MeasurementsMappaer());

    }



    public static class MeasurementsMappaer implements RowMapper<Measurement> {
        @Override
        public Measurement mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Measurement(
                rs.getTimestamp("timestamp").toInstant(),
                rs.getNString("source"),
                rs.getDouble("value")
            );
        }
    }
}
