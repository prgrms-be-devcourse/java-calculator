package com.programmers.calculator.controller;

import com.programmers.calculator.domain.OperationResult;
import com.programmers.calculator.model.Calculator;
import com.programmers.calculator.model.Validator;
import com.programmers.calculator.repository.ResultRepository;
import com.programmers.calculator.view.Input;
import com.programmers.calculator.view.Output;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Controller {
    private ResultRepository repository;
    private Input input;
    private Output output;
    private Calculator calculator;

    public Controller(ResultRepository repository, Input input, Output output, Calculator calculator) {
        this.repository = repository;
        this.input = input;
        this.output = output;
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
        output.printlnString("");
        output.printlnString("1.조회");
        output.printlnString("2.계산");
        output.printlnString("");
        output.printString("선택 : ");

        String inputModeStr = input.inputStr();
        if (!Pattern.matches(Validator.NUMBER_REGEX, inputModeStr))
            return -1;

        return Integer.parseInt(inputModeStr);
    }

    public void calculateFomula() {
        String inputString = input.inputStr();
        String[] parsedInputStr = parseFolmula(inputString);

        Validator.isRightSpacing(parsedInputStr);
        Validator.isRightOperatorAndNumbers(parsedInputStr);

        Optional<OperationResult> operationResult = calculator.calculate(inputString, parsedInputStr);
        Validator.isDivisionZero(operationResult);

        repository.save(operationResult.get());
        System.out.println(operationResult.get());
    }
    public String[] parseFolmula(String inputStr) {
        return inputStr.trim().split("\\s+");
    }

    public void printHistory() {
        if (repository.isEmpty()) {
            output.printNoHistory();
        } else {
            long index = 0L;

            while (true) {
                Optional<OperationResult> data = repository.findById(index++);
                if (data.isEmpty())
                    break;

                output.printHistory(data.get());
            }
        }
    }
}
