package com.prgrms.ndy.repository;

import com.prgrms.ndy.domain.Calculation;
import com.prgrms.ndy.domain.CommandUnit;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class H2CalculationRepository implements CalculationRepository {

    private final DataSource dataSource;

    public H2CalculationRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Calculation calculation) {
        log.info("save : {}", calculation);

        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO calculation (expression, result) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, calculation.getCommand().toString());
            statement.setString(2, calculation.getResult().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            log.info("save error :", e);
        }

    }

    @Override
    public List<Calculation> findAll() {
        log.info("findAll");

        List<Calculation> ret = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM calculation";
            ResultSet resultSet = conn.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                String expression = resultSet.getString("expression");
                Number result = resultSet.getDouble("result");
                ret.add(new Calculation(CommandUnit.of(expression), result));
            }
            return ret;
        } catch (SQLException e) {
            log.info("save error :", e);
        }
        return null;
    }

    @Override
    public int clear() {
        log.debug("clear");

        try (Connection conn = dataSource.getConnection()) {
            String sql = "DELETE FROM calculation";
            return conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            log.info("clear error :", e);
        }

        return -1;
    }
}
