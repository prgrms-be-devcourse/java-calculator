package org.programmers.calculator.integration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.calculator.configuration.ObjectContainer;
import org.programmers.calculator.configuration.Operand;
import org.programmers.calculator.postfixCalculator.PostfixSolver;
import org.programmers.calculator.postfixParser.PostfixParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Boolean 기본 연산")
public class BooleanCalculatorTest {

    @BeforeAll
    static void beforeAll() {
        ObjectContainer.create(Operand.BOOLEAN);
    }

    @Test
    @DisplayName("!부정")
    void plus() {
        PostfixParser parser = ObjectContainer.getParser();
        PostfixSolver solver = ObjectContainer.getSolver();

        String input = "! T";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("F", result);
    }

    @Test
    @DisplayName("And")
    void minus() {
        PostfixParser parser = ObjectContainer.getParser();
        PostfixSolver solver = ObjectContainer.getSolver();

        String input = "T & F";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("F", result);
    }

    @Test
    @DisplayName("Or")
    void multiply() {
        PostfixParser parser = ObjectContainer.getParser();
        PostfixSolver solver = ObjectContainer.getSolver();

        String input = "F | T";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("T", result);
    }

    @Test
    @DisplayName("->")
    void materialImplication() {
        PostfixParser parser = ObjectContainer.getParser();
        PostfixSolver solver = ObjectContainer.getSolver();

        String input = "T -> F";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("F", result);
    }

    @Test
    @DisplayName("복합")
    void multiplyWithPlus() {
        PostfixParser parser = ObjectContainer.getParser();
        PostfixSolver solver = ObjectContainer.getSolver();

        String input = "T & ! F | F";
        List<String> postfixExpression = parser.parse(input);
        String result = solver.solve(postfixExpression);

        assertEquals("T", result);
    }
}