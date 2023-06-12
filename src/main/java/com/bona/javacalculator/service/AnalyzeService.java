package com.bona.javacalculator.service;

import java.util.Stack;

public class AnalyzeService {
//    private static final char WHITE_SPACE = ' ';

    //숫자,연산자 구분
    public Double analyzeStr(String input) {
        //숫자만 저장
        Stack<Object> numbers = new Stack<>();
        char c = ' ';
        double num1 = 0;
        double num2 = 0;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (Character.isDigit(c)) {
                numbers.push(c);
            } else {
                num2 = Double.parseDouble(numbers.pop().toString());
                num1 = Double.parseDouble(numbers.pop().toString());
                //연산자면 계산 후 스택에 저장
//                calculateReal(num1, num2, c,numbers);
                switch (c) {
                    case '+' -> numbers.push(num1 + num2);
                    case '-' -> numbers.push(num1 - num2);
                    case '*' -> numbers.push(num1 * num2);
                    case '/' -> numbers.push(num1 / num2);
                }
            }
        }
        return Double.valueOf(numbers.pop().toString());
    }
}
