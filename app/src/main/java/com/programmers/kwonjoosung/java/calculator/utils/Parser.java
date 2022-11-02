package com.programmers.kwonjoosung.java.calculator.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final static String ADD = "+";
    private final static String SUB = "-";
    private final static String MUL = "*";
    private final static String DIV = "/";
    private final static DecimalFormat FORMAT = new DecimalFormat("#.##");

    public static String[] parsing(String data) { // 정규식을 적용하면 더 좋을 것 같은데...
        List<String> expression = new ArrayList<>();

        String[] letters = data.trim().split("\\s+");

        int number = 0, operation = 0, index = 0;
        try {
            for (String letter : letters) {
                index++;
                // 1단계 특수문자 중에 +,-,*,/ 인지 확인 (2번째 값만 체크)
                if (index % 2 == 0 && (ADD.equals(letter) || SUB.equals(letter) || MUL.equals(letter) || DIV.equals(letter))) {
                    expression.add(letter);
                    operation++;
                } else { // 2단계 숫자 인지 확인
                    expression.add(FORMAT.format(Double.parseDouble(letter)));
                    number++;
                }
            }
        } catch (NumberFormatException e) { // 예외를 케이스 별로 다양하게 나눠야 하는가?
            throw new NumberFormatException("올바른 연산식을 입력해주세요.");
        }
        // 3단계 숫자랑 연산자의 개수의 차이가 1인지 확인
        if (number - 1 != operation) throw new IllegalArgumentException("올바르지 않은 연산입니다.");

        return expression.toArray(new String[0]);
    }
}
