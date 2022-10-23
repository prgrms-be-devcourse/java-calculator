package com.programmers.java.calculator;

import com.programmers.java.data.Store;
import com.programmers.java.io.Console;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Store store = new Store();
    Console console = new Console();
    Calculator c = new Calculator(console, console, store);

    // 입력 validation 테스트
    @Test
    void testValidateTrue(){
        String s = "(3 - 4) * 6";
        assertTrue(c.validate(s));
    }

    @Test
    void testValidateFalse(){
        String s1 = "(3";
        String s2 = "3 4";
        String s3 = "3 - 4)";
        String s4 = "3 4 -";

        assertFalse(c.validate(s1));
        assertFalse(c.validate(s2));
        assertFalse(c.validate(s3));
        assertFalse(c.validate(s4));
    }

    // 우선순위 연산 테스트
    @Test
    void testPriorityCalculate(){
        String s1 = "(3 - 4) * 6";
        String s2 = "3 - 4 * 6";

        assertEquals(-6, c.calculate(s1).getAnswer());
        assertEquals(-21, c.calculate(s2).getAnswer());
    }
}
