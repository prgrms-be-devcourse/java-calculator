package com.programmers.junho;

import com.programmers.junho.controller.CalculatorController;
import com.programmers.junho.view.BufferedReaderInputView;
import com.programmers.junho.view.InputView;
import com.programmers.junho.view.OutputView;
import com.programmers.junho.view.PrintStreamOutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new BufferedReaderInputView();
        OutputView outputView = new PrintStreamOutputView();

        CalculatorController calculator = new CalculatorController(inputView, outputView);
        calculator.run();
    }
}
