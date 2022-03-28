package com.programmers.calculator;

import com.programmers.calculator.util.io.Console;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataForCalculator {
    private final String[] origin;
    private final String result;

    DataForCalculator(String[] origin, String result) {
        this.origin = origin;
        this.result = result;
    }

    public String[] getOrigin() {
        return origin;
    }

    public String getResult() {
        return result;
    }
}

@DisplayName("계산기 내부 로직 테스트")
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        Console console = new Console();
        calculator = new Calculator(console, console);
    }

    @DisplayName("isValidate() 테스트")
    @Nested
    class ValidateTest {
        @DisplayName("유효한 식인 경우")
        @ParameterizedTest(name = "{0} 식의 괄호가 알맞게 구성되어 있습니다.")
        @ValueSource(strings = {"1+2", "1 / 2 +3", "(1.1+2) /3", "1-2 * 3", "1 + ( 2 - 3 ) * 4 + 5"})
        void validationSuccess(String formula) {
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
            try {
                Method method = calculator.getClass().getDeclaredMethod("isValidate", String.class);
                method.setAccessible(true);
                assertFalse((Boolean) method.invoke(calculator, formula));
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @DisplayName("calculate() 테스트")
    @Nested
    class CalculateTest {
        @DisplayName("후위 표기식으로 변경이 완료되 경우")
        @Test
        void CalculateSuccess() {
            List<DataForCalculator> list = new ArrayList<>();
            list.add(new DataForCalculator(new String[]{"1", "2", "+"}, "3.0"));
            list.add(new DataForCalculator(new String[]{"1", "2", "/", "3", "+"}, "1.6666666666666665"));
            list.add(new DataForCalculator(new String[]{"1.1", "2", "+", "3", "/"}, "1.7666666666666666"));
            list.add(new DataForCalculator(new String[]{"1", "2", "3", "*", "-"}, "-5.0"));
            list.add(new DataForCalculator(new String[]{"1", "2", "3", "-", "4", "*", "5", "+", "+"}, "-24.0"));

            try {
                Method method = calculator.getClass().getDeclaredMethod("calculate", String[].class);
                method.setAccessible(true);
                list.forEach(dataForCalculator -> {
                    try {
                        assertEquals(dataForCalculator.getResult(), method.invoke(calculator, (Object) dataForCalculator.getOrigin()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
