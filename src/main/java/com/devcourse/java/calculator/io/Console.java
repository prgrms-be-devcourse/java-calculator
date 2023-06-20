package com.devcourse.java.calculator.io;

import com.devcourse.java.calculator.InputValidator;
import com.devcourse.java.calculator.constant.Menu;

import java.util.List;
import java.util.Scanner;

public class Console {

    private final Scanner scanner = new Scanner(System.in);

    public void printCommandMenu() {
        System.out.println();
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.println();
        System.out.print("선택 : ");
    }

    public void printCalculateHistory(List<String> history) {
        InputValidator.checkCalculateHistoryLength(history);
        history.forEach(System.out::println);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printRequestEquationInput() {
        System.out.print("식을 입력하세요: ");
    }

    public void printAnswerFromEquation(String answer) {
        String[] splitAnswer = answer.split(" ");
        System.out.println(splitAnswer[splitAnswer.length - 1]);
    }

    public int getCommand() {
        String command = scanner.nextLine();
        Menu.checkCommandInput(command);

        return Integer.parseInt(command);
    }

    public String getEquation() {
        String equation = scanner.nextLine();
        InputValidator.checkEquationInput(equation);

        return equation;
    }
}
