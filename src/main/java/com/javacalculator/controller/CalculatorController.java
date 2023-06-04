package com.javacalculator.controller;

import com.javacalculator.view.InputView;
import com.javacalculator.view.OutputView;

public class CalculatorController {

    public static void main(String[] args) {
        OutputView.outputMenu();
        int menuNumber = InputView.inputMenuNumber();
    }
}
