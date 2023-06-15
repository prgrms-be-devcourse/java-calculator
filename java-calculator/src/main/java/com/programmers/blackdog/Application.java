package com.programmers.blackdog;

import com.programmers.blackdog.controller.CalculatorController;
import com.programmers.blackdog.view.InputView;
import com.programmers.blackdog.view.OutputView;
import com.programmers.blackdog.view.PrintStreamOutputView;
import com.programmers.blackdog.view.ScannerInputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ScannerInputView();
        OutputView outputView = new PrintStreamOutputView();

        CalculatorController calculator = new CalculatorController(inputView, outputView);
        calculator.run();
    }
}
