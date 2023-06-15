package com.programmers.blackdog;

import com.programmers.blackdog.controller.CalculatorController;
import com.programmers.blackdog.view.*;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ScannerInputView();
        OutputView outputView = new PrintStreamOutputView();
        Console console = new Console(inputView, outputView);

        CalculatorController calculator = new CalculatorController(console);
        calculator.run();
    }
}
