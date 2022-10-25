package com.programmers.kwonjoosung.java.calculator.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BasicParser implements Parser {
    private final static String ADD = "+";
    private final static String SUB = "-";
    private final static String MUL = "*";
    private final static String DIV = "/";
    private final static String BLANK ="";
    private final DecimalFormat FORMAT = new DecimalFormat("#.##");
    @Override
    public String[] parsing(String data) { // 정규식을 적용하면 더 좋을 것 같은데...
        String[] letters = data.trim().split("\\s+");
        if(letters.length == 1) letters = data.split(""); // 연산을 이어서 한 경우도 처리하기 위해서 ex) 1+1 -> "1","+","1"
        if(letters.length % 2 == 0)
            throw new IllegalArgumentException("올바르지 않은 연산입니다.");

        List<String> expression = new ArrayList<>();
        int number = 0;
        int operation = 0;
        int index = 1;
        try {
            for(String letter :letters){
                // 1단계 특수문자 중에 +,-,*,/ 인지 확인 (2번째 값만 체크)
                if(index%2==0 && (ADD.equals(letter) || SUB.equals(letter) || MUL.equals(letter) ||DIV.equals(letter))){
                    expression.add(letter);
                    operation++;
                } else { // 2단계 숫자 인지 확인
                    if (BLANK.equals(letter)) continue;
                    expression.add(FORMAT.format(Double.parseDouble(letter)));
                    number++;
                }
                index++;
            }
        } catch (NumberFormatException e) { // 예외를 케이스 별로 다양하게 나눠야 하는가?
            throw new NumberFormatException("올바른 연산식을 입력해주세요.");
        }
        // 3단계 숫자랑 연산자의 개수의 차이가 1인지 확인
        if (number-1 != operation) throw new IllegalArgumentException("올바르지 않은 연산입니다.");

        return expression.toArray(new String[0]);
    }
}
