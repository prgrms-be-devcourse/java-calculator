package com.programmers.calculator.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validator 내부 로직 테스트")
public class ValidatorTest {
    private Validator<String> validator;

    @BeforeEach
    void setUp() {
        validator = FormulaValidator.getInstance();
    }

    @DisplayName("checkBracket() 테스트")
    @Nested
    class CheckBracketTest {
        @DisplayName("유효한 식인 경우")
        @ParameterizedTest(name = "{0} 식의 괄호가 알맞게 구성되어 있습니다.")
        @ValueSource(strings = {"1+2", "1 / 2 +3", "(1.1+2) /3", "1-2 * 3", "1 + ( 2 - 3 ) * 4 + 5"})
        void validationSuccess(String formula) {
            try {
                Method method = validator.getClass().getDeclaredMethod("checkBracket", String.class);
                method.setAccessible(true);
                assertTrue((Boolean) method.invoke(validator, formula));
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        @DisplayName("유효하지 않은 식인 경우")
        @ParameterizedTest(name = "{0} 식의 괄호가 알맞게 구성되어 있지 않습니다.")
        @ValueSource(strings = {"1+2)", "(1 / 2 +3", "((1.1+2) /3", "1-2 (* 3", "1 + ( 2 - 3 )) * 4 + 5"})
        void validationFail(String formula) {
            try {
                Method method = validator.getClass().getDeclaredMethod("checkBracket", String.class);
                method.setAccessible(true);
                assertFalse((Boolean) method.invoke(validator, formula));
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @DisplayName("checkInvalidCharacter() 테스트")
    @Nested
    class CheckInvalidCharacterTest {
        @DisplayName("유효한 식인 경우")
        @ParameterizedTest(name = "{0} 식은 숫자와 연산자로 구성되어 있습니다.")
        @ValueSource(strings = {"1+2", "1 / 2 +3", "(1.1+2) /3", "1-2 * 3", "1 + ( 2 - 3 ) * 4 + 5"})
        void validationSuccess(String formula) {
            try {
                Method method = validator.getClass().getDeclaredMethod("checkInvalidCharacter", String.class);
                method.setAccessible(true);
                assertTrue((Boolean) method.invoke(validator, formula));
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        @DisplayName("유효하지 않은 식인 경우")
        @ParameterizedTest(name = "{0} 식은 숫자와 연산자 이외의 문자가 들어가 있습니다..")
        @ValueSource(strings = {"1+2&", "$1 / 2 +3", "(#1.1+2) /3", "1-2 @ 3", "1 + ( 2 - 3 )) ~ 4 + 5"})
        void validationFail(String formula) {
            try {
                Method method = validator.getClass().getDeclaredMethod("checkInvalidCharacter", String.class);
                method.setAccessible(true);
                assertFalse((Boolean) method.invoke(validator, formula));
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
