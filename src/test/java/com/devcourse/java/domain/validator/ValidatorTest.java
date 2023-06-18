package com.devcourse.java.domain.validator;

import com.devcourse.java.common.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @Test
    @DisplayName("빈 리스트 검사 테스트")
    void isEmptyTest() {
        // given
        List<String> strings = new ArrayList<>();

        // when
        boolean notEmpty = Validator.isNotEmpty(strings);

        // then
        assertThat(notEmpty).isFalse();
    }

    @Nested
    @DisplayName("계산식 유효성 테스트")
    class validExpressionTest {
        @ParameterizedTest
        @DisplayName("[성공] 이상 없는 계산식")
        @ValueSource(strings = {"1 + 2", "1 + 2 * 3", "3 - 2 * 2"})
        void validationSuccessTest(String expression) {
            // given

            // when
            boolean isNotValid = Validator.isNotValidExpression(expression);

            // then
            assertThat(isNotValid).isFalse();
        }

        @ParameterizedTest
        @DisplayName("[실패] 숫자와 연산자 외의 입력이거나 개수가 맞지 않아서 실패")
        @ValueSource(strings = {"1 + 1 1",
                                "1 + + 2",
                                "1 + * / 2",
                                "+ 2 3",
                                "a + 2",
                                "i am hejow"})
        void validationFailTest(String expression) {
            // given

            // when
            boolean isNotValid = Validator.isNotValidExpression(expression);

            // then
            assertThat(isNotValid).isTrue();
        }
    }

    @Nested
    @DisplayName("숫자 검증 테스트")
    class validateNumberTest {
        @ParameterizedTest
        @DisplayName("[성공] 이상 없이 숫자임")
        @ValueSource(strings = {"1", "12", "123", "1243", "123456"})
        void validationSuccessTest(String number) {
            // given

            // when
            boolean isNumber = Validator.isNumber(number);

            // then
            assertThat(isNumber).isTrue();
        }

        @ParameterizedTest
        @DisplayName("[실패] 숫자가 아님")
        @ValueSource(strings = {"!", "a2", "1c3", "희조"})
        void validationFailTest(String number) {
            // given

            // when
            boolean isNumber = Validator.isNumber(number);

            // then
            assertThat(isNumber).isFalse();
        }
    }
}
