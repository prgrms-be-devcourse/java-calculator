package com.programmers.java.calculator.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InfixValidator implements Validator{

    private final String operator =  "^[+*/-]$";
    private final String formula = "^([-|+*/(]?\\d*[)]?)*$";
    private final String bracket = "^[()]$";
    private final String start = "^[-+(]?\\d*$";

    public void validate(String s) {

        if(!s.matches(formula)) validationException();

        String[] exp = s.split("");

        if(!exp[0].matches(start) | exp[exp.length-1].matches(operator)) validationException();

        // 식 유효성 검사
        long countNum = Arrays.stream(exp).filter(i -> i.matches("^\\d$")).count();
        long countOperator = Arrays.stream(exp).filter(i -> i.matches("^[+*/-]$")).count();
        if (countNum <= countOperator) validationException();


        // 괄호 검사
        List<String> bracket = Arrays.asList(exp).stream()
                .filter(i -> i.matches(this.bracket))
                .collect(Collectors.toList());
        int bracketNum = 0;

        if (!bracket.isEmpty()) {
            for (String b : bracket) {
                if (b.equals("(")) bracketNum += 1;
                else bracketNum -= 1;
            }
            if (bracketNum != 0) {
                validationException();
            }
        }


    }

    private void validationException() {
        throw new IllegalArgumentException("옳지 않은 입력입니다. 수식을 다시 한번 확인해주세요.");
    }
}
