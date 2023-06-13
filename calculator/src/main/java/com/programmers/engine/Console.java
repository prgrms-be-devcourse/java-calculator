package com.programmers.engine;

import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import com.programmers.engine.util.Confirmation;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input() {
        String calculationCommand = scanner.nextLine();
        calculationCommandValidation(calculationCommand);
        return calculationCommand;
    }

    @Override
    public String choose() {
        System.out.print("선택 : ");
        String selectionNumber = scanner.nextLine();
        selectionNumberValidation(selectionNumber);
        System.out.println();
        return selectionNumber;
    }

    @Override
    public void printStart() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
    }

    @Override
    public void printResult(Integer calculationResult) {
        System.out.println(calculationResult);
        System.out.println();
    }

    @Override
    public void printHistory(List<String> history) {
        history.forEach(System.out::println);
        System.out.println();
    }

    private static void calculationCommandValidation(String calculationCommand) {
        if (Pattern.compile(" ")
                .splitAsStream(calculationCommand)
                .filter(e -> !(Confirmation.isOperator(e) || Confirmation.isOperand(e)))
                .findAny()
                .isPresent()) {
            throw new IllegalArgumentException("잘못된 계산식 입니다.");
        }
    }

    private static void selectionNumberValidation(String selectionNumber) {
        if (!(selectionNumber.equals("1") || selectionNumber.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2 를 입력해 주세요");
        }
    }
}
