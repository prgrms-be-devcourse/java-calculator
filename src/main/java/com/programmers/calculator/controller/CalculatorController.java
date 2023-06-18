package com.programmers.calculator.controller;

import com.programmers.calculator.constant.OptionType;
import com.programmers.calculator.domain.core.Calculator;
import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.domain.vo.Expression;
import com.programmers.calculator.repository.CalculationHistory;
import com.programmers.calculator.repository.HistoryRepository;
import com.programmers.calculator.view.Console;

import java.util.List;

public class CalculatorController {

    private final Console console;
    private final Calculator calculator;
    private final HistoryRepository repository;

    public CalculatorController(Console console, Calculator calculator, HistoryRepository repository) {
        this.console = console;
        this.calculator = calculator;
        this.repository = repository;
    }

    public void run() {

        while (true) {

            try {
                console.outputOption();
                OptionType inputValue = OptionType.of(console.inputOption());

                switch (inputValue) {
                    case EXIT:
                        exitCalculator();
                        break;
                    case HISTORY:
                        loadCalculationHistory();
                        break;
                    case CALCULATION:
                        processCalculation();
                        break;
                    default:
                        errorDetection();
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                e.printStackTrace();
            }

        }
    }

    private void exitCalculator() {
        console.outputExit();
        System.exit(0);
    }

    private void loadCalculationHistory() {
        List<CalculationHistory> calculationHistoryList = repository.findAll();
        console.outputHistory(calculationHistoryList);
    }

    private void processCalculation() {
        Expression expression = new Expression(console.inputExpression());
        CalculationResult calculationResult = calculator.calculate(expression);

        printCalculationResult(calculationResult);
        saveCalculationResult(expression, calculationResult);
    }

    private void printCalculationResult(CalculationResult calculationResult) {
        console.outputCalculation(calculationResult);
    }

    private void saveCalculationResult(Expression expression, CalculationResult calculationResult) {
        CalculationHistory calculationHistory = new CalculationHistory(expression, calculationResult);
        repository.save(calculationHistory);
    }

    private void errorDetection() {
        System.exit(0);
    }

}
