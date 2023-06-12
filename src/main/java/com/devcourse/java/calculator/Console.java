package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.MenuConstant;
import com.devcourse.java.calculator.io.Input;
import com.devcourse.java.calculator.io.Output;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator validator = new InputValidator();

    @Override
    public void printCommandMenu() {
        System.out.println();
        System.out.println(MenuConstant.PRINT_COMMAND_FIRST_HISTORY);
        System.out.println(MenuConstant.PRINT_COMMAND_SECOND_CALCULATE);
        System.out.println(MenuConstant.PRINT_COMMAND_THIRD_EXIT);
        System.out.println();
        System.out.print(MenuConstant.REQUEST_COMMAND_INT);
    }

    @Override
    public void printCalculateHistory(LinkedHashMap<Integer, String> calculateHistory) {
        validator.checkCalculateHistoryLength(calculateHistory);
        calculateHistory.values().forEach(System.out::println);
    }

    @Override
    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printRequestEquationInput() {
        System.out.print(MenuConstant.REQUEST_EQUATION);
    }

    @Override
    public void printAnswerFromEquation(String answer) {
        String[] splitAnswer = answer.split(" ");
        System.out.println(splitAnswer[splitAnswer.length - 1]);
    }

    @Override
    public int getCommand() {
        String command = scanner.nextLine();
        validator.checkCommandInput(command);

        return Integer.parseInt(command);
    }

    @Override
    public String getEquation() {
        String equation = scanner.nextLine();
        validator.checkEquationInput(equation);

        return equation;
    }
}
