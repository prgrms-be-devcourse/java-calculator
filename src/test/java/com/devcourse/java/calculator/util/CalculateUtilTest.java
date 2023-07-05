package com.devcourse.java.calculator.util;

import com.devcourse.java.calculator.constant.ExceptionMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculateUtilTest {

    @Test
    @DisplayName("식 계산 결과 확인")
    void calculateAndReturnEquationWithAnswer_Test() {
        //given
        String equation1 = "5 + 10";
        String equation2 = "10 + 2 * 50 + 30";
        String equation3 = "1 + 2 + 3 + 4 + 5";
        String equation4 = "6 + 10 / 2 + 4";
        String equation5 = "5 * 10 / 2 + 10";

        //when
        String Answer = CalculateUtil.calculateAndReturnAnswer(equation1);
        String Answer2 = CalculateUtil.calculateAndReturnAnswer(equation2);
        String Answer3 = CalculateUtil.calculateAndReturnAnswer(equation3);
        String Answer4 = CalculateUtil.calculateAndReturnAnswer(equation4);
        String Answer5 = CalculateUtil.calculateAndReturnAnswer(equation5);


        //then
        assertThat(Answer).isEqualTo("15.0");
        assertThat(Answer2).isEqualTo("140.0");
        assertThat(Answer3).isEqualTo("15.0");
        assertThat(Answer4).isEqualTo("15.0");
        assertThat(Answer5).isEqualTo("35.0");

    }

    @Test
    @DisplayName("0으로 나눌 때 ArithmeticException 확인")
    void calculateAndReturnEquationWithAnswer_Divide_By_Zero_EXCEPTION_Test() {
        //given
        String equation1 = "2 + 5 / 0 * 3";
        String equation2 = "5 / 0";

        //when, then
        assertThatThrownBy(() -> CalculateUtil.calculateAndReturnAnswer(equation1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining(ExceptionMessageConstant.DIVIDE_BY_ZERO_EXCEPTION);

        assertThatThrownBy(() -> CalculateUtil.calculateAndReturnAnswer(equation2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining(ExceptionMessageConstant.DIVIDE_BY_ZERO_EXCEPTION);

    }
}