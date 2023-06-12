package model;

public class Calculator {
    private final Operand operand;

    public Calculator() {
        this.operand = new Operand();
    }

    public String calculate(String expression) throws RuntimeException {
        for (String expressionComponent : expression.split("")) {
            if (Character.isDigit(expressionComponent.charAt(0))) {
                operand.push(Integer.parseInt(expressionComponent));
                continue;
            }
            calculateIfOperatorNotEmpty(expressionComponent);
        }
        return makeFinalCalculation();
    }

    private void calculateIfOperatorNotEmpty(String expressionComponent) {
        Operator currentOperator = Operator.getOperator(expressionComponent);
        if (!Operator.isEmpty()) {
            calculateByPrecedence(currentOperator);
        }
        Operator.push(currentOperator);
    }

    private void calculateByPrecedence(Operator currentOperator) {
        Operator peekOperator = Operator.peek();
        if (peekOperator.getPrecedence() >= currentOperator.getPrecedence()) {
            int rightNumber = operand.pop();
            int leftNumber = operand.pop();
            operand.push(peekOperator.applyCalculate(leftNumber, rightNumber));
            Operator.pop();
        }
    }

    private String makeFinalCalculation() {
        Operator currentOperator = Operator.pop();
        int rightNumber = operand.pop();
        int leftNumber = operand.pop();
        return String.valueOf(currentOperator.applyCalculate(leftNumber, rightNumber));
    }
}


