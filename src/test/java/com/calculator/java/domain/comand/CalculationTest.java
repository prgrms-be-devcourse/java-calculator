package com.calculator.java.domain.comand;

import com.calculator.java.Calculator;
import com.calculator.java.domain.database.Database;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationTest {
    Command calculation = new Calculation(new Database());

    @Test
    void 더하기_테스트() {
        String exp1 = "11 + 22";
        String exp2 = "11 + 22 + 33 + -22 + 44 + 55";

        ((Calculation)calculation).setMathExpression(exp1);
        String result1 = calculation.doCommand();

        ((Calculation)calculation).setMathExpression(exp2);
        String result2 = calculation.doCommand();

        assertThat(result1).isEqualTo("33");
        assertThat(result2).isEqualTo("143");
    }

    @Test
    void 빼기_테스트() {
        String exp1 = "11 - 22";
        String exp2 = "11 - 22 - 33 - -22 - 44 - 55";

        ((Calculation)calculation).setMathExpression(exp1);
        String result1 = calculation.doCommand();

        ((Calculation)calculation).setMathExpression(exp2);
        String result2 = calculation.doCommand();


        assertThat(result1).isEqualTo("-11");
        assertThat(result2).isEqualTo("-121");
    }

    @Test
    void 더하기_빼기_혼합_테스트() {
        String exp = "11 + 22 + 33 - -22 - 44 - 55";

        ((Calculation)calculation).setMathExpression(exp);
        String result = calculation.doCommand();

        assertThat(result).isEqualTo("-11");
    }
}