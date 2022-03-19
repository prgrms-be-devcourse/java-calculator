package com.prgrms.ndy;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void contextLoad() {
    }

    @Test
    void inMemoryDbTest() throws SQLException {
        Connection conn = DriverManager.
                getConnection("jdbc:h2:~/test", "sa", "");
        conn.close();
    }
}