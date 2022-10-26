package com.programmers.calculator.core;

import com.programmers.calculator.util.DecimalUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("DecimalUnit 테스트")
class DecimalUtilTest {


    @DisplayName("숫자 입력값이 .0 으로 끝나면 .0을 지워준 문자열을 리턴한다.")
    @Test
    void formatToStringWithOutDecimalPoint() {
        //given
        Number number = 5.0;
        String actualNumber = "5";
        //when
        String formatNumber = DecimalUtil.formatToString(number);

        //then
        assertEquals(actualNumber, formatNumber);

    }

    @DisplayName("숫자 입력값이 .0으로 끝나지 않는다면 소숫점을 포함한 문자열을 리턴한다.")
    @Test
    void formatToStringWithDecimalPoint() {
        //given
        Number number = 3.1;
        String actualNumber = "3.1";

        //when
        String formatNumber = DecimalUtil.formatToString(number);

        //then
        assertEquals(actualNumber, formatNumber);
    }

}