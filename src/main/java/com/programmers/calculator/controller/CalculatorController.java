package com.programmers.calculator.controller;

import com.programmers.calculator.domain.Calculator;
import com.programmers.calculator.repository.CalculationHistory;
import com.programmers.calculator.repository.HistoryRepository;
import com.programmers.calculator.view.Console;

import java.math.BigDecimal;
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
                    saveCalculationResult(processCalculation());
                    break;
                default:
                    console.outputOption();
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

    private CalculationHistory processCalculation() {
        String inputExpression = console.inputExpression();
        BigDecimal result = calculator.calculate(inputExpression);
        console.outputCalculation(result);

        return new CalculationHistory(inputExpression, result);
    }

    private void saveCalculationResult(CalculationHistory calculationHistory) {
        repository.save(calculationHistory);
    }

}
