package com.programmers.calculator.controller;

import com.programmers.calculator.entity.Operation;
import com.programmers.calculator.model.Calculator;
import com.programmers.calculator.model.Validator;
import com.programmers.calculator.repository.Repository;
import com.programmers.calculator.view.Console;

import java.util.Optional;
import java.util.regex.Pattern;

public class Controller {
    private final Repository repository;
    private final Console console;
    private final Calculator calculator;
    //private Map<String, >

    public Controller(Repository repository, Console console, Calculator calculator) {
        this.repository = repository;
        this.console = console;
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            int mode = inputMode();
            switch (mode) {
                case 1:
                    printHistory();
                    break;
                case 2:
                    calculateFomula();
                    break;
                default:
                    throw new IllegalArgumentException("잘못된 기능을 입력하셨습니다.");
            }
        }
    }

    public int inputMode() {
        console.printlnString("");
        console.printlnString("1.조회");
        console.printlnString("2.계산");
        console.printlnString("");
        console.printString("선택 : ");

        String inputModeStr = console.inputStr();
        if (!Pattern.matches(Validator.NUMBER_REGEX, inputModeStr))
            return -1;

        return Integer.parseInt(inputModeStr);
    }

    public void calculateFomula() {
        String inputString = console.inputStr();
        String[] parsedInputStr = parseFolmula(inputString);

        Validator.isRightSpacing(parsedInputStr);
        Validator.isRightOperatorAndNumbers(parsedInputStr);

        Operation operation = calculator.calculate(inputString, parsedInputStr);

        repository.save(operation);
        System.out.println(operation);
    }
    public String[] parseFolmula(String inputStr) {
        return inputStr.trim().split("\\s+");
    }

    public void printHistory() {
        if (repository.isEmpty()) {
            console.printNoHistory();
        } else {
            long index = 0L;

            while (true) {
                Optional<Operation> data = repository.findById(index++);
                if (data.isEmpty())
                    break;

                console.printHistory(data.get());
            }
        }
    }
}
