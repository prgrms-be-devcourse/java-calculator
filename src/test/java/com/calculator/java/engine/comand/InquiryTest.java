package com.calculator.java.engine.comand;

import com.calculator.java.database.Database;
import com.calculator.java.engine.comand.inquiry.Inquiry;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InquiryTest {
    Database database = Database.getInstance();
    Command selection = new Inquiry(database);

    @Test
    void 계산_이력_테스트 () {
        String exp1 = "11 + 22 = 33";
        String exp2 = "11 + 22 / 2 * 3 = 44";
        String exp3 = "11 * 22 + 33 * -22 - 44 + 55 = -473";

        database.add("11 + 22", "33");
        database.add("11 + 22 / 2 * 3", "44");
        database.add("11 * 22 + 33 * -22 - 44 + 55", "-473");

        String result = selection.doCommand();

        assertThat(result).isEqualTo(exp1+"\n"+exp2+"\n"+exp3);
    }

    @Test
    void 계산_이력_없는_경우_테스트 () {
        String result = selection.doCommand();

        assertThat(result).isEqualTo("");
    }
}