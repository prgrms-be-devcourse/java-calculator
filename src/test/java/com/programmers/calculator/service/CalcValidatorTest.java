package com.programmers.calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcValidatorTest {
    CalcValidatorService vs = new CalcValidatorService();

    @Test
    @DisplayName("숫자와 연산기호만 있는지 확인")
    void onlyNumsAndSymbolsTest() {
        // given
        String str = "1 + 3 + 5 . 6";

        // when
        Boolean result = vs.checkNumsAndSymbol(str);

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("띄워쓰기 두번이상 하나로 처리")
    void moreThanDoubleSpacingTest() {
        // given
        String str = "1  + 3 + 1";

        // when
        String result = vs.checkSpacing(str);

        // then
        assertEquals("1 + 3 + 1", result);
    }

    @Test
    @DisplayName("연산기호가 전부 짝지어졌는지 확인")
    void  symbolMatchingTest(){
        // given
        String str = "1 + 3 + 1 +";

        // when
        boolean result = vs.checkSymbolMatching(str);

        // then
        assertFalse(result);
    }
}
