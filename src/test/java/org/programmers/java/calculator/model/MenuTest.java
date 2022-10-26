package org.programmers.java.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    @DisplayName("입력값에 따라서 반환되는 메뉴를 검증하라")
    void selectMenu() {
        //give
        String inputRecord = "1";
        String inputCalculate = "2";
        String inputExit = "3";
        String inputError = "-1";

        //when
        Menu selectMenuRecord = Menu.selectMenu(inputRecord);
        Menu selectMenuCalculate = Menu.selectMenu(inputCalculate);
        Menu selectMenuExit = Menu.selectMenu(inputExit);
        Menu selectMenuError = Menu.selectMenu(inputError);

        //then
        assertEquals(Menu.RECORD, selectMenuRecord);
        assertEquals(Menu.CALCULATE, selectMenuCalculate);
        assertEquals(Menu.EXIT, selectMenuExit);
        assertEquals(Menu.ERROR, selectMenuError);
    }


}