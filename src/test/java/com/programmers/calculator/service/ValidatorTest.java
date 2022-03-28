package com.programmers.calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    ValidatorService vs = new ValidatorService();

    @Test
    @DisplayName("숫자와 연산기호만 있는지, 띄워쓰기 확인")
    void onlyNumsAndSymbolsTest() {
        // given
        String str = "1 + 3 + 5 . 6";

        // when
        boolean result = vs.checkNumsAndSymbol(str);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("연산기호가 전부 짝지어졌는지 확인")
    void symbolMatchingTest() {
        // given
        String str = "-1 + -3 + 1";
        str = "-1 + -1";

        // when
        boolean result = vs.checkSymbolMatching(str);

        // then
        assertFalse(result);
    }
}
