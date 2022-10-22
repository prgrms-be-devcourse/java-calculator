package com.programmers.java;

import com.programmers.java.io.Console;
import com.programmers.java.repository.HistoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculateTest {
    @Test
    void calculate() {
        Calculator calculator = new Calculator(new Console(), new HistoryRepository(), new FormulaParser());
        String[] postfixFormula1 = {"1", "2", "+", "3", "/", "5", "-", "7", "-"};
        String[] postfixFormula2 = {"12", "23", "+"};

        int result1 = calculator.calculate(postfixFormula1);
        int result2 = calculator.calculate(postfixFormula2);

        Assertions.assertEquals(result1, -11);
        Assertions.assertEquals(result2, 35);
    }
}