package org.example.view;

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

    public Integer readCommand() {
        return inputView.readCommand();
    }

}
