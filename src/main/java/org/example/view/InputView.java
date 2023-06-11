package org.example.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private final Scanner sc = new Scanner(System.in);
    private final Pattern REGEX_SELECT = Pattern.compile("[12]");
    private final Pattern REGEX_EXPRESSION = Pattern.compile("\\d+(\\s[+\\-*/]\\s\\d+)*");

    public String selectWork() {
        String selection = sc.nextLine();

        if (validateSelection(selection)) {
            return selection;
        }
        sc.nextLine();

        return "넌틀렸어";
    }

    public String inputExpression() {
        String expression = sc.nextLine();

        if (validateExpression(expression)) {
            return expression;
        }

        return "수식이 잘못됐습니다.";
    }

    private boolean validateSelection(String selection) {

        if (REGEX_SELECT.matcher(selection).matches()) {
            return true;
        }

        return false;
    }

    public boolean validateExpression(String expression) {

        if (REGEX_EXPRESSION.matcher(expression).matches()) {
            return true;
        }

        return false;
    }

}
