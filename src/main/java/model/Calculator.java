package model;

public class Calculator {
    private final Operand operand;

    public Calculator() {
        this.operand = new Operand();
    }

    public String calculate(String expression) throws RuntimeException {
        for (String expComponent : expression.split("")) {
            if (Character.isDigit(expComponent.charAt(0))) {
                operand.push(Integer.parseInt(expComponent));
                continue;
            }

            Operator currentOperator = Operator.getOperator(expComponent);
            if (!Operator.isEmpty()) {
                Operator peekOperator = Operator.peek();
                if (peekOperator.getPrecedence() >= currentOperator.getPrecedence()) {
                    int rightNumber = operand.pop();
                    int leftNumber = operand.pop();
                    int result = peekOperator.applyCalculate(leftNumber, rightNumber);
                    operand.push(result);
                    Operator.pop();
                }
            }
            Operator.push(currentOperator);
        }

        Operator currentOperator = Operator.pop();
        int rightNumber = operand.pop();
        int leftNumber = operand.pop();
        return String.valueOf(currentOperator.applyCalculate(leftNumber, rightNumber));
    }
}


