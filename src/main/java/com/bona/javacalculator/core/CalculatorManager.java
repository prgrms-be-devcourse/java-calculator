package com.bona.javacalculator.core;

import com.bona.javacalculator.core.calculator.Calculator;
import com.bona.javacalculator.core.converter.Converter;
import com.bona.javacalculator.io.Console;
import com.bona.javacalculator.model.ExpressionResult;
import com.bona.javacalculator.repository.MemoryRepository;
import com.bona.javacalculator.util.Validator;

import java.util.List;

public class CalculatorManager {

    private final Converter converter;
    private final Validator validator;
    private final MemoryRepository repository;
    private final Console console;
    private final Calculator calculator;

    public CalculatorManager(Calculator calculator, MemoryRepository repository, Console console,Converter converter, Validator validator) {
        this.repository = repository;
        this.console = console;
        this.converter = converter;
        this.validator = validator;
        this.calculator = calculator;
    }

    public void run() {
        boolean isRun = true;

        while (isRun) {
            try {
                String input = console.input("1. 조회 2. 계산 3.종료");

                Option option = Option.of(input);

                switch (option) {
                    case INQUIRY -> inquiry();
                    case CALCULATE -> calculate();
                    case EXIT -> isRun = false;
                    default -> {
                    }
                }
            } catch (RuntimeException e) {
                console.printMessage(e.getMessage());
            }
        }
    }


    public void calculate() {
        String formula = console.input("식을 입력해주세요 : ");

        validator.validateFormula(formula);

        List<String> postfix = converter.convert(formula);
        double result = calculator.calculate(postfix);

        repository.save(new ExpressionResult(formula, result));

        console.outAnswer(result);
    }


    public void inquiry() {
        List<ExpressionResult> all = repository.findAll();

        if (all.isEmpty()) {
            console.printMessage("조회 결과 기록이 존재하지 않습니다");
            return;
        }

        console.printAll(all);
    }

}
