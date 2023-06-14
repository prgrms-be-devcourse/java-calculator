package com.programmers.calculator.controller;

import com.programmers.calculator.domain.Calculator;
import com.programmers.calculator.repository.CalculationHistory;
import com.programmers.calculator.repository.HistoryRepository;
import com.programmers.calculator.view.Input;
import com.programmers.calculator.view.Output;

import java.math.BigDecimal;
import java.util.List;

public class CalculatorController {
    private final Input inputConsole;
    private final Output outputConsole;
    private final Calculator calculator;
    private final HistoryRepository historyRepository;

    public CalculatorController(Input inputConsole, Output outputConsole, Calculator calculator, HistoryRepository historyRepository) {
        this.inputConsole = inputConsole;
        this.outputConsole = outputConsole;
        this.calculator = calculator;
        this.historyRepository = historyRepository;
    }

    public void run() {
        while (true) {
            outputConsole.outputOption();
            OptionType inputValue = OptionType.of(inputConsole.inputOption());

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
                    outputConsole.outputOption();
            }
        }
    }

    private void exitCalculator() {
        outputConsole.outputExit();
        System.exit(0);
    }

    private void loadCalculationHistory() {
        List<CalculationHistory> calculationHistoryList = historyRepository.findAll();
        outputConsole.outputHistory(calculationHistoryList);
    }

    private CalculationHistory processCalculation() {
        String inputExpression = inputConsole.inputExpression();
        BigDecimal result = calculator.calculate(inputExpression);
        outputConsole.outputCalculation(result);

        return new CalculationHistory(inputExpression, result);
    }

    private void saveCalculationResult(CalculationHistory calculationHistory) {
        historyRepository.save(calculationHistory);
    }

}
