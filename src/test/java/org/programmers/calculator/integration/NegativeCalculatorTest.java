package org.programmers.calculator.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.postfixCalculator.NumeralCalculator;
import org.programmers.calculator.postfixCalculator.NumeralPrefixSolver;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;

import java.util.List;

@DisplayName("음수 연산")
public class NegativeCalculatorTest {

    @Test
    @DisplayName("음수 덧셈")
    void plus() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "5 + -7";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        Assertions.assertEquals("-2", result);
    }

    @Test
    @DisplayName("음수 곱셈")
    void multiply() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "-2 * 3";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        Assertions.assertEquals("-6", result);
    }

    @Test
    @DisplayName("음수 곱셈과 함께 덧셈")
    void multiplyWithPlus() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "1 + -2 * 3";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        Assertions.assertEquals("-5", result);
    }
}
