package org.example.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View implements Input,Output{

    private final Scanner sc = new Scanner(System.in);
    private final Pattern REGEX_EXPRESSION = Pattern.compile("\\d+(\\s[+\\-*/]\\s\\d+)*");

    @Override
    public int selectWork() {
        int selection = sc.nextInt();

        if (validateSelection(selection)) {
            return selection;
        }
        sc.nextLine();

        return -1;
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

    private boolean validateSelection(int selection) {
        int[] regex_select = {1, 2, 3};
        boolean regex_result = Arrays.stream(regex_select).anyMatch(num -> num == selection);

        return regex_result;
    }

    public boolean validateExpression(String expression) {

        if (REGEX_EXPRESSION.matcher(expression).matches()) {
            return true;
        }

        return false;
    }
}
