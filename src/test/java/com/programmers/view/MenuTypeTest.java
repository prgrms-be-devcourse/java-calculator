package com.programmers.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MenuTypeTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "0"})
    void containMenuNumTrue(String selectNum) {
        if (selectNum.equals("1") || selectNum.equals("2") || selectNum.equals("3")) {
            assertTrue(MenuType.containMenuNum(selectNum));
            return;
        }
        assertFalse(MenuType.containMenuNum(selectNum));

    }

}