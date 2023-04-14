package ru.mpei.dbclickhouse.repository;

import com.clickhouse.jdbc.ClickHouseConnection;
import com.clickhouse.jdbc.ClickHouseDataSource;
import com.clickhouse.jdbc.ClickHouseStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mpei.dbclickhouse.domain.Measurement;

@Component
@AllArgsConstructor
public class MeasurementsRepoNative {

    private final ClickHouseDataSource clickHouseDataSource;

    public void save(Measurement measurement) {
        try (ClickHouseConnection clickHouseConnection =
                 clickHouseDataSource.getConnection()) {

            clickHouseConnection.getTransaction();
            PreparedStatement preparedStatement =
                clickHouseConnection.prepareStatement("insert into measurement.test (source, timestamp, value) " +
                    "SETTINGS async_insert=1, wait_for_async_insert=0 " +
                    "values (?, ?, ?);");
            preparedStatement.setString(1, measurement.source());
            preparedStatement.setObject(2, measurement.timestamp());
            preparedStatement.setDouble(3, measurement.value());
            preparedStatement.addBatch();
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Measurement> findAll() {
        try {
            ClickHouseStatement statement = clickHouseDataSource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from measurement.test");
            List<Measurement> measurements = new ArrayList<>();
            while (resultSet.next()) {
                String source = resultSet.getString("source");
                long timestamp = resultSet.getLong("timestamp");
                double value = resultSet.getDouble("value");
                measurements.add(new Measurement(Instant.ofEpochMilli(timestamp), source, value));
            }
            return measurements;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
