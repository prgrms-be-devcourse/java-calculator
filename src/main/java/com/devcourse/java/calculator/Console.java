package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.MenuConstant;
import com.devcourse.java.calculator.io.Input;
import com.devcourse.java.calculator.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator validator = new InputValidator();

    @Override
    public void printCommandMenu() {
        System.out.println(MenuConstant.PRINT_COMMAND_FIRST_HISTORY);
        System.out.println(MenuConstant.PRINT_COMMAND_SECOND_CALCULATE);
        System.out.println(MenuConstant.PRINT_COMMAND_THIRD_EXIT);
        System.out.println();
        System.out.print(MenuConstant.REQUEST_COMMAND_INT);
    }

    @Override
    public int getCommand() {
        String command = scanner.nextLine();
        validator.checkCommandInput(command);

        return Integer.parseInt(command);
    }
}
