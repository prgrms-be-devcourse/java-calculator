package com.prgrms.ndy;

import com.prgrms.ndy.io.BufferedReaderWriter;
import com.prgrms.ndy.parsor.RegexParser;
import com.prgrms.ndy.repository.H2CalculationRepository;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:~/test");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        new Calculator(
                new RegexParser(),
                new BufferedReaderWriter(),
                new H2CalculationRepository(dataSource)
        )
                .run();
    }
}
