package com.programmers.calculator.controller;

import com.programmers.calculator.domain.Calculator;
import com.programmers.calculator.view.Input;
import com.programmers.calculator.view.Output;

public class CalculatorController {
    private final Input inputConsole;
    private final Output outputConsole;
    private final Calculator calculator;

    public CalculatorController(Input inputConsole, Output outputConsole, Calculator calculator) {
        this.inputConsole = inputConsole;
        this.outputConsole = outputConsole;
        this.calculator = calculator;
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
                    saveCalculationResult();
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
    }

    private void saveCalculationResult() {
    }


}
