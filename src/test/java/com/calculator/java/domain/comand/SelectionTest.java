package com.calculator.java.domain.comand;

import com.calculator.java.domain.database.Database;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SelectionTest {
    Database database = new Database();
    Command selection = new Selection(database);

    @Test
    void 계산_이력_테스트 () {
        String exp1 = "11 + 22 = 33";
        String exp2 = "11 + 22 / 2 * 3 = 44";
        String exp3 = "11 * 22 + 33 * -22 - 44 + 55 = -473";

        database.add(exp1);
        database.add(exp2);
        database.add(exp3);

        String result = ((Selection)selection).doCommand();

        assertThat(result).isEqualTo(exp1+"\n"+exp2+"\n"+exp3);
    }

    @Test
    void 계산_이력_없는_경우_테스트 () {
        String result = ((Selection)selection).doCommand();

        assertThat(result).isEqualTo("");
    }
}