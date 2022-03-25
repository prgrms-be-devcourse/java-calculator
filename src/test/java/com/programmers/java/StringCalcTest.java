package com.programmers.java;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

public class StringCalcTest {

    Calculator c = new Calculator();
    String str = "3 + 2 + 4 * 5 + 3 / 1";

    @Test
    public void 입력식_유효성테스트() {
        StringTokenizer s = new StringTokenizer(str);
        Assertions.assertTrue(c.invalidCheck(s));
    }

    @Test
    public void 후위표기법_변환_테스트() {
        StringTokenizer s = new StringTokenizer(str);
        Assertions.assertEquals("324531 /*+++", c.PostFixForm(s));
    }

    @Test
    public void 후위표기법_수식계산_테스트() {
        StringTokenizer s = new StringTokenizer(str);
        String form = c.PostFixForm(s);
        Assertions.assertEquals(28, c.Calc(form));
    }
}
