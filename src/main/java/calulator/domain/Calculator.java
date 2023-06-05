package calulator.domain;

import calulator.input.InputView;

public class Calculator {

    private final InputView inputView = new InputView();

    private final void run() {
        int i = inputView.inputMenu();
        if (i == 2) {

        }
    }

//    private int findPriority(String expression) {
//        for (int i = 0; i < expression.length(); i++) {
//            if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
//
//            }
//        }

    private void createExpression(String inputValue) {
        List<String> expressions = StringSplitter.splitByOperator(inputValue);
        this.expression = new Expression(expressions);
    }

    private String getCalculateResult(String inputValue) {
        createExpression(inputValue);
        String calculateResult = expression.calculate();
        expressionRepository.addExpression(inputValue, calculateResult);
        return calculateResult;
    }

}
