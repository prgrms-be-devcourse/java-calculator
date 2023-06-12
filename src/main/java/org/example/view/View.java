package org.example.view;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View implements Input,Output{

    private final Scanner sc = new Scanner(System.in);
    private final Pattern REGEX_SELECT = Pattern.compile("[123]");
    private final Pattern REGEX_EXPRESSION = Pattern.compile("\\d+(\\s[+\\-*/]\\s\\d+)*");

    @Override
    public String selectWork() {
        String selection = sc.nextLine();

        if (validateSelection(selection)) {
            return selection;
        }
        sc.nextLine();

        return "넌틀렸어";
    }

    @Override
    public String inputExpression() {
        String expression = sc.nextLine();

        if (validateExpression(expression)) {
            return expression;
        }

        return "수식이 잘못됐습니다.";
    }

    @Override
    public void printSelection(){
        System.out.println("1.조회");
        System.out.println("2.계산");
        System.out.println("3.종류");
        System.out.println();
        System.out.print("선택 : ");
    }

    @Override
    public void printResult(double result) {
        System.out.println(result);
    }

    @Override
    public void printRecords(List<String> arithmeticRecords) {
        arithmeticRecords.stream().forEach(System.out::println);
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
