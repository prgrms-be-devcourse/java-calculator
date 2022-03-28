package com.programmers.calculator;

import com.programmers.calculator.util.io.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("계산기 내부 로직 테스트")
public class CalculatorTest {
    @DisplayName("isValidate() 테스트")
    @Nested
    class ValidateTest{
        @DisplayName("유효한 식인 경우")
        @ParameterizedTest(name = "{0} 식의 괄호가 알맞게 구성되어 있습니다.")
        @ValueSource(strings = {"1+2", "1 / 2 +3", "(1.1+2) /3", "1-2 * 3", "1 + ( 2 - 3 ) * 4 + 5"})
        void validationSuccess(String formula) {
            Console console = new Console();
            Calculator calculator = new Calculator(console, console);
            try {
                Method method = calculator.getClass().getDeclaredMethod("isValidate", String.class);
                method.setAccessible(true);
                assertTrue((Boolean) method.invoke(calculator, formula));
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        @DisplayName("유효하지 않은 식인 경우")
        @ParameterizedTest(name = "{0} 식의 괄호가 알맞게 구성되어 있지 않습니다.")
        @ValueSource(strings = {"1+2)", "(1 / 2 +3", "((1.1+2) /3", "1-2 (* 3", "1 + ( 2 - 3 )) * 4 + 5"})
        void validationFail(String formula) {
            Console console = new Console();
            Calculator calculator = new Calculator(console, console);
            try {
                Method method = calculator.getClass().getDeclaredMethod("isValidate", String.class);
                method.setAccessible(true);
                assertFalse((Boolean) method.invoke(calculator, formula));
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
