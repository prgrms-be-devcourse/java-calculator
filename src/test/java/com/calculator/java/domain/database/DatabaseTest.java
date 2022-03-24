package com.calculator.java.domain.database;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DatabaseTest {
    Database database = new Database();

    @Test
    void 데이터_조회_테스트() {
        database.add("1 + 2 + 3 = 6");
        database.add("1 + 2 = 3");
        String ret = database.get();

        assertThat(ret).isEqualTo("1 + 2 + 3 = 6\n1 + 2 = 3\n");
    }

}