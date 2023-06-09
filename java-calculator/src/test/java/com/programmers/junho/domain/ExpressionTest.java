package com.programmers.junho.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ExpressionTest {
    @DisplayName("올바른 형식의 식이면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "1 - 3", "1 * 2", "4 / 2", "12 + 23 * 45"})
    void name(String expression) {
        assertThatNoException().isThrownBy(() -> new Expression(expression));
    }

    @DisplayName("공백이 존재하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1+2", "1-3", "12+23* 45"})
    void name3(String expression) {
        assertThatThrownBy(() -> new Expression(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("식과 연산 사이에 공백 개수가 하나 이상이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1  + 2, 1 -   2", "3 * 4 /   6"})
    void name2(String expression) {
        assertThatThrownBy(() -> new Expression(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 형식이나 순서의 식이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 & 2", "/ 1 + ", "1 / + 2"})
    void name6(String expression) {
        assertThatThrownBy(() -> new Expression(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중위 표현식을 후위 표현식으로 변환한다.")
    @ParameterizedTest(name = "중위 : {0}, 후위 : {1}")
    @CsvSource(value = {"3 + 4 * 2:3 4 2 * +", "1 + 2 * 3 + 4 / 2 + 2:1 2 3 * + 4 2 / + 2 +", "4 + 5 * 6 / 2 - 3:4 5 6 * 2 / + 3 -", "44 / 2:44 2 /"}, delimiter = ':')
    void name7(String infixExpression, String postfixExpression) {
        Expression expression = new Expression(infixExpression);

        String actual = expression.getPostfixExpression();

        assertThat(actual).isEqualTo(postfixExpression);
    }
}