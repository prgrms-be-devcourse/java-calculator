package com.prgrms.ndy;

import org.apache.commons.io.IOUtils;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

public class AppInitializer {

    private final DataSource dataSource;

    public AppInitializer() {
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:~/test");
        jdbcDataSource.setUser("sa");
        jdbcDataSource.setPassword("");
        this.dataSource = jdbcDataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void init() throws SQLException, IOException {
        executeDdls(dataSource);
    }

    private static void executeDdls(DataSource dataSource) throws IOException, SQLException {
        String[] ddls = IOUtils.toString(Application.class.getResourceAsStream("/schema.sql"), StandardCharsets.UTF_8)
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
