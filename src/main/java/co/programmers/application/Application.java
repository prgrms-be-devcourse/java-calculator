package co.programmers.application;

import co.programmers.view.CalculatorInputView;
import co.programmers.view.CalculatorOutputView;
import co.programmers.view.InputView;
import co.programmers.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new CalculatorInputView();
        OutputView outputView = new CalculatorOutputView();
        Calculator calculator = new Calculator(inputView, outputView);
        calculator.run();
    }
}
