package org.programmers.java.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    @DisplayName("메뉴를 선택하세요")
    void selectMenu() {
        Menu menuRecord = Menu.selectMenu("1");
        Menu menuCalculate = Menu.selectMenu("2");
        Menu menuExit = Menu.selectMenu("3");
        Menu Error = Menu.selectMenu("-1");
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }
}