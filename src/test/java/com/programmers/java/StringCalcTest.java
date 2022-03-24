package com.programmers.java;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

public class StringCalcTest {

    Calculator c = new Calculator();
    String str = "-12 - -3 * -2";
    StringTokenizer s = new StringTokenizer(str);

    @Test
    public void 입력식_유효성테스트() {
        Assertions.assertTrue(c.invalidCheck(s));
    }

}
