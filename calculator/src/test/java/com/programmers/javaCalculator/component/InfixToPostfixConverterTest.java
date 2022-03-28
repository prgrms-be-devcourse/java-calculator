package com.programmers.javaCalculator.component;

import com.programmers.javaCalulator.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InfixToPostfixConverterTest {

    InfixToPostfixConverter converter = new InfixToPostfixConverter();

    @Test
    @DisplayName("입력받은 값의 유효성 검사 및 중위식을 후위식으로의 변환")
    void convert() {
        /* 연산자와 피연자의 개수의 합이 2개 이하일 경우 */
        assertThatThrownBy(() -> converter.put("11").convert())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_ENOUGH_ELEMENTS);
        assertThatThrownBy(() -> converter.put("*").convert())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_ENOUGH_ELEMENTS);
        assertThatThrownBy(() -> converter.put("1 +").convert())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_ENOUGH_ELEMENTS);

        /* 연산자와 피연자의 개수의 합이 짝수일 경우 */
        assertThatThrownBy(() -> converter.put("1 + 3 *").convert())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_ENOUGH_ELEMENTS);

        /* 피연산자의 위치에 정의되지 않은 피연산자가 입력된 경우 */
        assertThatThrownBy(() -> converter.put("1 + *").convert())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_DEFINED_OPERAND);

        /* 연산자의 위치에 정의되지 않은 연산자가 입력된 경우 */
        assertThatThrownBy(() -> converter.put("1 % 5 + 3").convert())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_DEFINED_OPERATOR);

        /* 유효성을 검증받은 중위식이 입력된 경우 */
        assertThat(converter.put("2 + 3 * 4").convert()).isEqualTo("234*+");
        assertThat(converter.put("6 * 5 + 2").convert()).isEqualTo("65*2+");
    }

}