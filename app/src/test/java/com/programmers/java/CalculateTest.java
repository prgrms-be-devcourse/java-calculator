package com.programmers.java;

import com.programmers.java.io.Screen;
import com.programmers.java.repository.RepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculateTest {
    @Test
    void calculate() {
        Calculator calculator = new Calculator(new Screen(), new RepositoryImpl(), new FormulaParser());
        String postfixFormula = "12+3/5+7-";

        String result = calculator.calculate(postfixFormula);

        Assertions.assertEquals(result, "-1");
    }
}