package com.calculator.java.database;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DatabaseTest {
    Database database = new Database();

    @Test
    void 데이터_조회_테스트() {
        database.add("1 + 2 + 3", 6);
        database.add("1 + 2", 3);

        assertThat(database.get().size()).isEqualTo(2);
        assertThat(database.get().get(0)).isEqualTo("1 + 2 + 3 = 6");
        assertThat(database.get().get(1)).isEqualTo("1 + 2 = 3");
    }

}