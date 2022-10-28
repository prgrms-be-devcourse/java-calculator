package com.programmers.java.controller;

import com.programmers.java.calculator.Calculator;
import com.programmers.java.exception.DivideByZeroException;
import com.programmers.java.repository.Repository;
import com.programmers.java.validator.InputValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Console implements Controller {
    private static final Scanner scanner = new Scanner(System.in);
    private final List<InputValidator> validatorList;
    private final Calculator calculator;
    private final Repository repository;

    public Console(List<InputValidator> validatorList, Calculator calculator, Repository repository) {
        this.validatorList = validatorList;
        this.calculator = calculator;
        this.repository = repository;
    }

    @Override
    public void run() {
        String choice = getInput("0. 종료\n1. 조회\n2. 계산\n 선택 : ");
        System.out.println();

        if ("0".equals(choice)) {
            System.out.println("프로그램을 종료합니다");
            return;
        } else if ("1".equals(choice)) {
            this.lookUpProcess();
        } else if ("2".equals(choice)) {
            this.calculateProcess();
        } else {
            System.out.println("0 or 1 or 2를 입력하세요!");
        }
        System.out.println();
        run();
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public boolean isNotValidated(String input) {
        for (InputValidator validator : validatorList) {
            if (!validator.validate(input)) {
                validator.printErrorMessage();
                return true;
            }
        }
        return false;
    }

    private void lookUpProcess() {
        for (Map.Entry<String, Double> entry : repository.findAll().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    private void calculateProcess() {
        String input = getInput("올바른 계산식 형태: 1 + ( 1 * ( 2 + 4 ) )\n 계산식 입력 : ");
        double result = 0;

        if (this.isNotValidated(input)) {
            return;
        }

        Optional<Double> cashed = repository.findOne(input);
        if (cashed.isPresent()) {
            System.out.println(cashed.get());
            return;
        }

        try {
            result = calculator.calculate(input);
        } catch (DivideByZeroException e) {
            System.out.println("0으로 나눌 수 없습니다");
            return;
        } catch (Exception e) {
            System.out.println("잘못된 입력 형식입니다");
            return;
        }

        repository.save(input, result);
        System.out.println(result);
    }
}
