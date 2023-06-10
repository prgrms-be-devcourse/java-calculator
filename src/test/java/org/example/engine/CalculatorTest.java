package org.example.engine;

import org.example.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    Console console;
    Calculator calculator;

    @BeforeEach
    void setUp() {
        this.console = new Console();
        this.calculator = new Calculator(this.console);
    }

    @DisplayName("사칙연산 입력 검증 통과 테스트")
    @ParameterizedTest
    @MethodSource("passValidateExpressionTestData")
    void passValidateExpressionTest(String expression){
        boolean expected = true;
        boolean actual = calculator.validateExpression(expression);
        assertEquals(expected, actual);


    }

    @DisplayName("사칙연산 입력 검증 실페 테스트")
    @ParameterizedTest
    @MethodSource("failValidateExpressionTestData")
    void failValidateExpressionTest(String expression){
        boolean expected = false;
        boolean actual = calculator.validateExpression(expression);
        assertEquals(expected, actual);

    }


    private static List<String> passValidateExpressionTestData() {
        return Arrays.asList(
            "1 + 2 / 3 * 4 - 5",
            "1    +     2     /   3   *   4   -   5",
            "1+2/3*4",
            "2222222222+33333333/4*777777-2"
        );
    }

    private static List<String> failValidateExpressionTestData() {
        return Arrays.asList(
                "1 + 2 / 3 * 4 -",
                "1 + +  2     /   3   *   4   -   5",
                "1+2/ 3 4",
                "     "
        );
    }



}