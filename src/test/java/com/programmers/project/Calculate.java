package com.programmers.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Calculate {
    Calculator calculator = new Calculator();

    @Test
    void 후위연산() {
        String result = calculator.priority("3+2*4");

        Assertions.assertEquals("324*+", result);
    }
}
