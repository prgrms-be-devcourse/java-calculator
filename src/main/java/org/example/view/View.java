package org.example.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View implements Input,Output{

    private final Scanner sc = new Scanner(System.in);
    private final Pattern REGEX_EXPRESSION = Pattern.compile("\\d+(\\s[+\\-*/]\\s\\d+)*");

    @Override
    public int select() {
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

        return "수식이 잘못됐습니다";
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
        int[] regex_select = {1, 2, 3}; // 형변환 시 이루어진 영향으로 추가, 1,2,3의 의미를 파악하기 어려워 개선 필요
        return Arrays.stream(regex_select).anyMatch(num -> num == selection);

    }

    public boolean validateExpression(String expression) {
        return REGEX_EXPRESSION.matcher(expression).matches();
    }
}
