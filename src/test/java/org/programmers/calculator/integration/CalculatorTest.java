package org.programmers.calculator.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.postfixCalculator.NumeralCalculator;
import org.programmers.calculator.postfixCalculator.NumeralPrefixSolver;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;

import java.util.List;

@DisplayName("기본 연산")
public class CalculatorTest {

    @Test
    @DisplayName("기본 덧셈")
    void plus() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "7 + 5";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        Assertions.assertEquals("12", result);
    }

    @Test
    @DisplayName("기본 뺄셈")
    void minus() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "3 - 9";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        Assertions.assertEquals("-6", result);
    }

    @Test
    @DisplayName("기본 곱셈")
    void multiply() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "2 * 3";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        Assertions.assertEquals("6", result);
    }

    @Test
    @DisplayName("기본 나눗셈")
    void division() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "10 / 2";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        Assertions.assertEquals("5", result);
    }


    @Test
    @DisplayName("덧셈, 곱셈 복합")
    void multiplyWithPlus() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "1 + 2 * 3";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        Assertions.assertEquals("7", result);
    }

    @Test
    @DisplayName("사칙연산 혼재")
    void complexCalculation() {
        NumeralTypeChecker numeralTypeChecker = new NumeralTypeChecker();
        NumeralPostfixParser parser = new NumeralPostfixParser(numeralTypeChecker);
        NumeralPrefixSolver solver = new NumeralPrefixSolver(numeralTypeChecker, new NumeralCalculator(numeralTypeChecker));

        String input = "1 / 2 + 2 * 3 - 5";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        Assertions.assertEquals("1.5", result);
    }
}
