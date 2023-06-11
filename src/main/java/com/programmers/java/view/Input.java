package com.programmers.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Input {
    public Button enterMenu() throws IOException {

        Button button = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        try {
            switch (input) {
                case "1":
                    button = Button.SEARCH;
                    break;
                case "2":
                    button = Button.CALCULATE;
                    break;
                default:
                    throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
        } catch (Exception e) {
            System.out.println("계산기를 종료합니다.");
            System.exit(0);
        }
        return button;
    }

    public String enterExpression() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        return expression;
    }
}