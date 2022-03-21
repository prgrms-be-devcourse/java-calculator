package com.prgrms.ndy;

import com.prgrms.ndy.io.BufferedReaderWriter;
import com.prgrms.ndy.parsor.RegexParser;
import com.prgrms.ndy.repository.H2CalculationRepository;
import org.apache.commons.io.IOUtils;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws Exception {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:~/test");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        executeDdls(dataSource);

        new Calculator(
                new RegexParser(),
                new BufferedReaderWriter(),
                new H2CalculationRepository(dataSource)
        )
                .run();
    }

    private static void executeDdls(DataSource dataSource) throws IOException, SQLException {
        String[] ddls = IOUtils.toString(Application.class.getResourceAsStream("/schema.sql"), "UTF-8")
                .replaceAll("(--).*", " ")
                .replaceAll("\\s{2,}", " ").trim()
                .split(";");
        for (String ddl : ddls) {
            try(Connection conn =  dataSource.getConnection()){
                conn.createStatement().executeUpdate(ddl);
            }
        }
    }
}
