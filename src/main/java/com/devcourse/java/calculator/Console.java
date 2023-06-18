package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.Menu;
import com.devcourse.java.calculator.io.Input;
import com.devcourse.java.calculator.io.Output;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void printCommandMenu() {
        System.out.println();
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.println();
        System.out.print("선택 : ");
    }

    @Override
    public void printCalculateHistory(LinkedHashMap<Integer, String> calculateHistory) {
        InputValidator.checkCalculateHistoryLength(calculateHistory);
        calculateHistory.values().forEach(System.out::println);
    }

    @Override
    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printRequestEquationInput() {
        System.out.print("식을 입력하세요: ");
    }

    @Override
    public void printAnswerFromEquation(String answer) {
        String[] splitAnswer = answer.split(" ");
        System.out.println(splitAnswer[splitAnswer.length - 1]);
    }

    @Override
    public int getCommand() {
        String command = scanner.nextLine();
        Menu.checkCommandInput(command);

        return Integer.parseInt(command);
    }

    @Override
    public String getEquation() {
        String equation = scanner.nextLine();
        InputValidator.checkEquationInput(equation);

        return equation;
    }
}
