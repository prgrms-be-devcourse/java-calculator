package com.programmers.javaCalculator.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * PostfixCalculator객체에는 로직을 통해 InfixToPostfixConverter객체를 거쳐
 * 유효성을 검증받은 후위식만 입력값으로 들어온다.
 */
class PostfixCalculatorTest {

    PostfixCalculator calculator = new PostfixCalculator();

    @Test
    @DisplayName("입력받은 후위식의 결과값을 반환")
    void calculate() {
        assertThat(calculator.calculate("123*+42+2/+")).isEqualTo(10);
        assertThat(calculator.calculate("352*72-/+")).isEqualTo(5);
        assertThat(calculator.calculate("352+*9-")).isEqualTo(12);
    }

}