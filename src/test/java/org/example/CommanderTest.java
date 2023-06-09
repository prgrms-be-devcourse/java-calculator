package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommanderTest {

    @Test
    void isDigitTest() {
        assertTrue(Commander.isDigit('1'));
        assertFalse(Commander.isDigit('^'));
    }

    @Test
    void checkTest() {
        assertEquals(false, Commander.check(new String[] {"1", "^"}));
        assertEquals(true, Commander.check(new String[] {"1", "+", "3"}));
    }
}

