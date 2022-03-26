package com.waterfogsw.io;

import com.waterfogsw.domain.Calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.List;

public class Console implements Input, Output {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int inputMenu(String prompt) throws IOException {
        System.out.print(prompt);
        String input = br.readLine();

        System.out.println();
        if (!isValidMenu(input)) throw new InputMismatchException();
        else return Integer.parseInt(input);
    }

    @Override
    public String inputExpr(String prompt) throws IOException {
        System.out.print(prompt);
        String input = br.readLine();
        System.out.println();
        if (isValidExpr(input)) return input;
        else return null;
    }

    @Override
    public void printResult(String expr, String result) {
        System.out.println(expr + " = " + result);
        System.out.println();
    }

    @Override
    public void printHistories(List<Calculation> calculations) {
        calculations.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void inputError() {
        System.out.println("잘못된 입력입니다.");
    }

    @Override
    public void divZeroError() {
        System.out.println("0으로 나눌 수 없습니다.");
    }

    private boolean isValidMenu(String menu) {
        return Integer.parseInt(menu) == 1 || Integer.parseInt(menu) == 2;
    }

    private boolean isValidExpr(String expr) {
        return true;
//        return expr.matches("^(([+*-/])|([0-9]{1,7}(\\\\.[0-9]{1,7})?)|\\s)+$");
    }

}
