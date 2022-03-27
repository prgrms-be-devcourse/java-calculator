package com.programmers.cal.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorLogicTest {

    private static final double VALID_RESULT_1 = 3.0;
    private static final double VALID_RESULT_2 = 10.0;
    private static final double VALID_RESULT_3 = -5.0;
    private static final double VALID_RESULT_4 = 21.0;
    private static final double VALID_RESULT_5 = 30.0;

    @DisplayName("계산 로직을 테스트합니다.")
    @Test
    void resultTest() {
        // Given
        String equation1 = "1 + 2";
        String equation2 = "1 + 2 + 3 -5 + 5 + 4";
        String equation3 = "1 - 6";
        String equation4 = "1 * 3 * 7";
        String equation5 = "15 * 2 / 1";

        // WHEN
        double result1 = CalculatorLogic.Calculation(equation1);
        double result2 = CalculatorLogic.Calculation(equation2);
        double result3 = CalculatorLogic.Calculation(equation3);
        double result4 = CalculatorLogic.Calculation(equation4);
        double result5 = CalculatorLogic.Calculation(equation5);

        //THEN
        assertThat(result1).isEqualTo(VALID_RESULT_1);
        assertThat(result2).isEqualTo(VALID_RESULT_2);
        assertThat(result3).isEqualTo(VALID_RESULT_3);
        assertThat(result4).isEqualTo(VALID_RESULT_4);
        assertThat(result5).isEqualTo(VALID_RESULT_5);
    }

}
