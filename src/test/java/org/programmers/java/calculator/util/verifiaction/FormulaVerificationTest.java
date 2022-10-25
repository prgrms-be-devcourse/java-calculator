package org.programmers.java.calculator.util.verifiaction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormulaVerificationTest {

    @Test
    @DisplayName("정상 플러스 입력에 대한 검증하라")
    void formulaVerifiactionPlus() {
        //given
        String input = "1 + 1";

        //when
        FormulaVerification.formulaVerifiaction(input);

        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("정상 마이너스 입력에 대한 검증하라")
    void formulaVerifiactionMinus() {
        //given
        String input = "1 - 1";

        //when
        FormulaVerification.formulaVerifiaction(input);

        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("정상 곱하기 입력에 대한 검증하라")
    void formulaVerifiactionMultiply() {
        //given
        String input = "1 * 1";

        //when
        FormulaVerification.formulaVerifiaction(input);

        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("정상 나누기 입력에 대한 검증하라")
    void formulaVerifiactionDivide() {
        //given
        String input = "1 / 1";

        //when
        FormulaVerification.formulaVerifiaction(input);

        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("비정상 연산자 입력에 대한 검증하라")
    void formulaVerifiactionNotPlus() {
        //given
        String input = "1 & 1";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(input);
        });

    }
}