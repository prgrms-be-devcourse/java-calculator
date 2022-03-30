package org.programmers.calculator.integration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.calculator.configuration.ObjectContainer;
import org.programmers.calculator.configuration.Operand;
import org.programmers.calculator.postfixCalculator.Solver;
import org.programmers.calculator.postfixParser.PostfixParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("기본 연산")
public class CalculatorTest {

    @BeforeAll
    static void beforeAll() {
        ObjectContainer.create(Operand.RATIONAL_NUMBER);
    }

    @Test
    @DisplayName("기본 덧셈")
    void plus() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "7 + 5";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("12", result);
    }

    @Test
    @DisplayName("기본 뺄셈")
    void minus() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "3 - 9";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("-6", result);
    }

    @Test
    @DisplayName("기본 곱셈")
    void multiply() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "2 * 3";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("6", result);
    }

    @Test
    @DisplayName("기본 나눗셈")
    void division() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "10 / 2";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("5", result);
    }

    @Test
    @DisplayName("0으로 나누기")
    void divideWithZero() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "4 / 0";

        List<String> postfixExpression = parser.parse(input);
        assertThrows(ArithmeticException.class, () -> solver.solve(postfixExpression));
    }

    @Test
    @DisplayName("덧셈, 곱셈 복합")
    void multiplyWithPlus() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "1 + 2 * 3";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("7", result);
    }

    @Test
    @DisplayName("사칙연산 혼재")
    void complexCalculation() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "1 / 2 + 2 * 3 - 5";

        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("1.5", result);
    }
}
