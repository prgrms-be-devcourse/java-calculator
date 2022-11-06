package com.programmers.calculate.engine;

import com.programmers.calculate.CalculatorHistory;
import com.programmers.calculate.Console;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Console console = new Console();
    private CalculatorHistory history = new CalculatorHistory();
    private Calculator calculator = new Calculator(console, console, history);

    @Test
    void 파싱() {
        String inputString = "1 + 2";

        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("+");

        assertEquals(queue, calculator.parse(inputString));
    }

    @Test
    void 우선순위() {
        String plus = "+";
        String multi = "*";
        String number = "1";

        assertEquals(1, calculator.getPriority(multi));
        assertEquals(2, calculator.getPriority(plus));
        assertEquals(3, calculator.getPriority(number));
    }

    @Test
    void 사칙연산() {
        Queue<String> case1 = calculator.parse("1 + 2");
        Queue<String> case2 = calculator.parse("1 + 2 * 3");

        assertEquals(3, calculator.calculate(case1));
        assertEquals(7, calculator.calculate(case2));
    }

}