package com.programmers.java.view;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    Input input = new Input();
    @Test
    void enterMenu() {
        String input = "1";  // 여기에 테스트에 사용할 입력을 작성합니다.
        BufferedReader reader = new BufferedReader(new StringReader(input));
         // 테스트 대상 객체에 BufferedReader를 주입합니다.




    }

    @Test
    void enterExpression() {
    }
}