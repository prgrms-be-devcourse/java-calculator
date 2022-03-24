package com.programmers.java;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

public class StringCalcTest {

    Calculator c = new Calculator();
    StringTokenizer s = new StringTokenizer("1 2 2 - 3");

    @Test
    public void 입력식_유효성테스트() {
        Assertions.assertFalse(c.invalidCheck(s));
    }
}
