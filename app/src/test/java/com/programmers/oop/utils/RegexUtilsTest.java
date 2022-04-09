package com.programmers.oop.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegexUtilsTest {

    @Test
    void isNumericYn() {
        //given
        String data = "123123123123";
        String data2 = "mkdasjkdnjk123p123i912m3kl1n23jkn12k3";
        //when, then
        assertTrue(RegexUtils.isNumericYn(data));
        assertFalse(RegexUtils.isNumericYn(data2));
    }

}