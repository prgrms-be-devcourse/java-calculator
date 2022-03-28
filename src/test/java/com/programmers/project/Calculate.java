package com.programmers.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.Scanner;

public class Calculate {
    Calculator calculator = new Calculator();

    @Test
    void 후위연산() {
        Queue<String> result = calculator.priority("3 + 2 * 4");
        StringBuilder sb = new StringBuilder();

        for(String str : result){
            sb.append(str);
        }

        Assertions.assertEquals("324*+", sb.toString());
    }

    @Test
    void 계산결과출력(){
        double result = calculator.calculate(calculator.priority("3 + 2 * 4"));

        Assertions.assertEquals(3+2*4, result);
    }
}
