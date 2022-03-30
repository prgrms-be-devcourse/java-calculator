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

@DisplayName("소수 연산")
public class FractionalCalculatorTest {

    @BeforeAll
    static void beforeAll() {
        ObjectContainer.create(Operand.RATIONAL_NUMBER);
    }

    @Test
    @DisplayName("소수 덧셈")
    void plus() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "5.1 + 7";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        assertEquals("12.1", result);
    }

    @Test
    @DisplayName("소수 곱셈")
    void multiply() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "-2.2 * 3";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        assertEquals("-6.6", result);
    }

    @Test
    @DisplayName("소수 복합")
    void multipleCalculation() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        String input = "1.2 + -2 * 3";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);
        assertEquals("-4.8", result);
    }
}
