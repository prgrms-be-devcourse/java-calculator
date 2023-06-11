package org.example.view;

import org.example.domain.Calculator;

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

    public void printOptionMessage() {
        outputView.printOptionMessage();
    }
    public void printCalcResult(Integer result) {
        outputView.printCalcResult(result);
    }

    //Controller에서 주입
    public void printMemory(Calculator calculator) {
        outputView.printMemory(calculator);
    }
}
