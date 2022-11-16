package com.programmers.java.engin.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {

    @Test
    @DisplayName("log 출력")
    void getLog() {
        final Log instance = new Log(new ConsoleInputExpression("7 + 4"),"11");
        final String log = instance.getLog();
        assertEquals("7 + 4 = 11",log);
    }
}