package calculator;

import calculator.calculator.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(getInputViewInstance(), getOutViewInstance());
        calculatorController.run();
    }

    private static InputView getInputViewInstance() {
        return new InputView();
    }

    private static OutputView getOutViewInstance() {
        return new OutputView();
    }
}
