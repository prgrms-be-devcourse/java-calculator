package com.programmers.java.io;

import com.programmers.java.entity.Calculation;
import com.programmers.java.enums.ErrorMessage;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    // Input
    @Override
    public String inputMenu() {
        return scanner.nextLine();
    }

    @Override
    public String inputFormula() {
        System.out.print("계산식 : ");
        return scanner.nextLine();
    }

    // Output
    @Override
    public void printMenu() {
        System.out.println();
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");
    }

    @Override
    public void printHistory(List<Calculation> history) {
        history.forEach(System.out::println);
    }

    @Override
    public void printMenuError() {
        System.out.println(ErrorMessage.INVALID_MENU_INPUT);
    }

    @Override
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    @Override
    public void printFormulaError(String message) {
        System.out.println(message);
    }

}
