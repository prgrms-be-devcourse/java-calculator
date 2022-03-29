package org.programmers.calculator.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.postfixCalculator.NumeralCalculator;
import org.programmers.calculator.postfixCalculator.NumeralPrefixSolver;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;

import java.util.List;

@DisplayName("소수 연산")
public class FractionalCalculatorTest {

    @Test
    @DisplayName("소수 덧셈")
    void plus() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "5.1 + 7";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        Assertions.assertEquals("12.1", result);
    }

    @Test
    @DisplayName("소수 곱셈")
    void multiply() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "-2.2 * 3";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        Assertions.assertEquals("-6.6", result);
    }

    @Test
    @DisplayName("소수 복합")
    void multipleCalculation() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "1.2 + -2 * 3";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        Assertions.assertEquals("-4.8", result);
    }
}
