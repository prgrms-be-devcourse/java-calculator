package org.example.view;

import java.util.List;

public class CalculatorView {
    final private InputView inputView;
    final private OutputView outputView;

    public CalculatorView() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public String readExpression() {
        return inputView.readExpression();
    }

    public String readCommand() {
        return inputView.readCommand();
    }

    public void printOptionMessage() {
        outputView.printOptionMessage();
    }
    public void printCalcResult(Integer result) {
        outputView.printCalcResult(result);
    }

    public void printHistory(List<String> history) {
        outputView.printHistory(history);
    }

    public void printExceptionMessage(String message) {
        outputView.printExceptionMessage(message);
    }
}
