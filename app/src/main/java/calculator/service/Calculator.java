package calculator.service;

import static calculator.view.InputView.inputExpression;
import static calculator.view.OutputView.showExpressionInputMessage;

public class Calculator {

    public void calculate() {
        showExpressionInputMessage();

        String infixExpression = inputExpression();
    }
}
