package com.prgrms.ndy.repository;

import com.prgrms.ndy.domain.Calculation;
import com.prgrms.ndy.domain.Command;
import com.prgrms.ndy.domain.CommandUnit;
import com.prgrms.ndy.parsor.Parser;
import com.prgrms.ndy.parsor.RegexParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.assertj.core.data.Offset;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class H2CalculationRepositoryTest {


    H2CalculationRepository calculationRepository;
    JdbcDataSource dataSource;
    Parser parser = new RegexParser();
    Offset<Double> OFFSET = Offset.offset(0.000_001);

    @BeforeEach
    void BeforeEach() throws SQLException, IOException {
        dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:~/test");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        calculationRepository = new H2CalculationRepository(dataSource);

        executeDdls();
    }

    private void executeDdls() throws IOException, SQLException {
        String[] ddls = IOUtils.toString(getClass().getResourceAsStream("/schema.sql"), "UTF-8")
                .replaceAll("(--).*", " ")
                .replaceAll("\\s{2,}", " ").trim()
                .split(";");
        for (String ddl : ddls) {
            try(Connection conn =  dataSource.getConnection()){
                conn.createStatement().executeUpdate(ddl);
            }
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1.0 + 2.0 + 3.0 + 4.0, 10",
        "-1.0 - -2.0 * -3.0 + 4.8, -2.2",
    })
    void 하나_저장하고_FindAll(String expr, double result) {
        Command command = parser.parse(expr);
        calculationRepository.save(new Calculation(command, result));

        List<Calculation> calcs = calculationRepository.findAll();
        for (Calculation calc : calcs) {
            System.out.println("calc = " + calc);
        }

        assertThat(calcs.size()).isEqualTo(1);
        assertThat(calcs.get(0).getCommand().toString()).isEqualTo(expr);
        assertThat(calcs.get(0).getResult().doubleValue()).isCloseTo(result,OFFSET);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1.0 + 2.0 + 3.0 + 4.0, 10, -1.0 - -2.0 * -3.0 + 4.8, -2.2",
    })
    void 두개_저장하고_FindAll(String expr1, double result1, String expr2, double result2) {
        Command command1 = parser.parse(expr1);
        Command command2 = parser.parse(expr2);

        calculationRepository.save(new Calculation(command1, result1));
        calculationRepository.save(new Calculation(command2, result2));

        List<Calculation> calcs = calculationRepository.findAll();
        for (Calculation calc : calcs) {
            System.out.println("calc = " + calc);
        }

        assertThat(calcs.size()).isEqualTo(2);
        assertThat(calcs.get(0).getCommand().toString()).isEqualTo(expr1);
        assertThat(calcs.get(0).getResult().doubleValue()).isCloseTo(result1,OFFSET);

        assertThat(calcs.get(1).getCommand().toString()).isEqualTo(expr2);
        assertThat(calcs.get(1).getResult().doubleValue()).isCloseTo(result2,OFFSET);
    }

    @AfterEach
    void afterEach() {
        int count = calculationRepository.clear();
        System.out.println("deleted count : " + count);
    }
}