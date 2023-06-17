package io;

import computation.Converter;
import computation.PostfixComputer;
import exception.ZeroDivisionException;
import repository.Repository;
import util.StringUtil;
import validation.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final Converter converter;
    private final PostfixComputer calculator;
    private final Repository repository;

    public Calculator(Converter converter, PostfixComputer calculator, Repository repository) {
        this.converter = converter;
        this.calculator = calculator;
        this.repository = repository;
    }

    public void printMenu() {
        System.out.println(MenuMessage.SELECT.getMessage());
        System.out.println(MenuMessage.CALCULATION.getMessage());
        System.out.println(MenuMessage.EXIT.getMessage());
        System.out.print(MenuMessage.CHOOSE.getMessage());
    }

    public String getUserInput() throws IOException {
        return br.readLine();
    }

    public void runInquiry() {
        System.out.println(DisplayMessage.SPLIT_LINE.getMessage());
        repository.inquiry();
        System.out.println(DisplayMessage.SPLIT_LINE.getMessage());
    }

    public void runCalculator() throws IOException {
        String getInput = StringUtil.removeWhiteSpace(getUserInput());
        if (!Validator.isRightExpression(getInput)) {
            System.out.println(DisplayMessage.WRONG_EXPRESSION.getMessage());
            return;
        }

        try {
            int result = calculator.calculate(converter.convert(getInput));
            repository.save(getInput, result);
            System.out.print(DisplayMessage.OUTPUT.getMessage());
            System.out.println(result);
        } catch (ZeroDivisionException e) {
            System.out.println(e.getMessage());
        }
    }


    public void runApplication() throws IOException {
        while (true) {
            printMenu();

            String getChoice = getUserInput();
            if (Validator.isNotNumber(getChoice)) {
                System.out.println(DisplayMessage.BAD_REQUEST.getMessage());
                continue;
            }

            int choice = Integer.parseInt(getChoice);
            if (choice == Menu.QUERY.getMenuNumber()) {
                // 조회
                runInquiry();
            } else if (choice == Menu.CALCULATE.getMenuNumber()) {
                // 계산
                runCalculator();
            } else if (choice == Menu.EXIT.getMenuNumber()) {
                // 종료
                System.exit(0);
            } else {
                System.out.println(DisplayMessage.BAD_REQUEST.getMessage());
            }
        }
    }
}
