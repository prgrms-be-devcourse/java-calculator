package com.programmers.junho.controller;

import com.programmers.junho.controller.constant.Selection;
import com.programmers.junho.domain.Calculator;
import com.programmers.junho.repository.CalculatorRepository;
import com.programmers.junho.repository.MemoryCalculatorRepository;
import com.programmers.junho.view.InputView;
import com.programmers.junho.view.OutputView;

import java.util.List;

import static com.programmers.junho.controller.constant.Selection.findByCode;

public class CalculatorController {

    public static final String EQUAL = " = ";
    private final CalculatorRepository calculatorRepository;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorRepository = new MemoryCalculatorRepository();
        System.out.println();
    }

    public void run() {
        Calculator calculator = new Calculator();
        while (true) {
            switch (getCode()){
                case CHECK_DATA:
                    printAllPreviousData();
                    break;
                case CALCULATE:
                    printCalculatedResultAndSave(calculator);
                    break;
                default:
                    throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
            }
        }
    }

    private Selection getCode() {
        outputView.printChoiceMessage();
        return findByCode(inputView.getSelectedCode());
    }

    private void printAllPreviousData() {
        List<String> calculatedData = calculatorRepository.findAll();
        outputView.printExpressions(calculatedData);
    }

    private void printCalculatedResultAndSave(Calculator calculator) {
        String expression = inputView.getExpression();
        int result = calculator.calculate(expression);
        outputView.printCalculatedResult(result);
        calculatorRepository.save(generateTotalResult(expression, result));
    }

    private String generateTotalResult(String expression, int result) {
        return expression + EQUAL + result;
    }
}