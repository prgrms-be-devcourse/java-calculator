package com.programmers.java.calculator;

import com.programmers.java.calculator.parser.InfixToPostFixParser;
import com.programmers.java.calculator.validator.InfixValidator;
import com.programmers.java.controller.CalculatorController;
import com.programmers.java.data.MapRepository;
import com.programmers.java.exception.CalculateException;
import com.programmers.java.exception.ValidateException;
import com.programmers.java.io.console.ConsoleInput;
import com.programmers.java.io.console.ConsoleOutput;
import com.programmers.java.io.Input;
import com.programmers.java.io.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private MapRepository store = new MapRepository();
    Input input = new ConsoleInput();
    Output output = new ConsoleOutput();
    InfixValidator validator = new InfixValidator();
    InfixToPostFixParser parseInput = new InfixToPostFixParser();

    ConsoleCalculator c = new ConsoleCalculator(store, parseInput);

    @DisplayName("입력 validation 테스트")
    @Test
    void testValidateTrue() {
        String s = "(3-4)*6";
        assertDoesNotThrow(() -> validator.validate(s));
    }

    @DisplayName("잘못된 수식 에러 전달 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"(3", "3 4", "3 - 4)", "3 4 -"})
    void testValidateFalse(String exp) {
        assertThrows(ValidateException.class, () -> validator.validate(exp));
    }

    @DisplayName("우선순위 연산 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"(3-4)*6, -6", "3-4*6, -21"})
    void testPriorityCalculate(String exp, Double answer) {
        assertEquals(c.calculate(exp), answer);
    }

    @DisplayName("0으로 나눌 경우 에러 전달 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3/0", "2/(4/2-2)"})
    void zeroDivisionExceptionTest(String exp) {
        assertThrows(CalculateException.class, () -> c.calculate(exp));
    }
}
