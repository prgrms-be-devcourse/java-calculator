package com.devcourse.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FormulaValidatorTest {

    @DisplayName("사용자로 부터 받은 식을 검증에 성공한다")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "1 - 2", "1 / 2 * 3"})
    void successValidateInputFormula(String formula) {
        assertThat(FormulaValidator.valid(formula)).isTrue();
    }

    @DisplayName("사용자로 부터 받은 식을 검증에 실패한다")
    @ParameterizedTest
    @ValueSource(strings = {"1+ 2", "1 -2", " 1 - 3", "1 + 2 ", "( 1 - 2) / 4", "4 - (2 + 3 * 4 ) / 5", "1 & 3", "(1 + 2)/ 3"})
    void failValidateInputFormula(String formula) {
        assertThat(FormulaValidator.valid(formula)).isFalse();
    }
}