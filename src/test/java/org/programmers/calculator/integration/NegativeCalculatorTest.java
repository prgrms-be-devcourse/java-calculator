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

@DisplayName("음수 연산")
public class NegativeCalculatorTest {

    @BeforeAll
    static void beforeAll() {
        ObjectContainer.create(Operand.RATIONAL_NUMBER);
    }

    @Test
    @DisplayName("음수 덧셈")
    void plus() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "5 + -7";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        assertEquals("-2", result);
    }

    @Test
    @DisplayName("음수 곱셈")
    void multiply() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "-2 * 3";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        assertEquals("-6", result);
    }

    @Test
    @DisplayName("음수 곱셈과 함께 덧셈")
    void multiplyWithPlus() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "1 + -2 * 3";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        assertEquals("-5", result);
    }
}
