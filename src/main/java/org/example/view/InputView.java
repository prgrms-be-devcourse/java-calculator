package org.example.view;

import java.util.Scanner;

import static org.example.domain.Validation.REGEX_EXPRESSION;
import static org.example.domain.Validation.REGEX_SELECT;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public String selectWorks() {
        String workNum = sc.nextLine();
        if(REGEX_SELECT.matcher(workNum).matches()){
            return workNum;
        }
        sc.nextLine();
        return "넌틀렸어";
    }

    public String inputExpression() {
        String expression = sc.nextLine();
        if(REGEX_EXPRESSION.matcher(expression).matches()){
            return expression;
        }
        return "수식이 잘못됐습니다.";
    }
}
