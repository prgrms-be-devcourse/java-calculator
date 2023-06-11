package model;

import util.Validator;

public class Calculator {
    private final Operand operand;
    private final Operator operator;

    public Calculator() {
        this.operand = new Operand();
        this.operator = new Operator();
    }

    public String calculate(String expression) {
        for (char component : expression.toCharArray()) {
            if (component == ' ') {
                continue;
            }

//            if (Validator.checkIsDigit(String.valueOf(component))) {
//                operand.push(Character.getNumericValue(component));
//                continue;
//            }

            if (!operator.isEmpty()) {
                OperatorType currentOperator = OperatorType.getOperator(String.valueOf(component));
                OperatorType peekOperator = operator.peekOperator();

                if (peekOperator.getPrecedence() >= currentOperator.getPrecedence()) {
                    int num2 = operand.pop();
                    int num1 = operand.pop();
                    int result = peekOperator.applyCalculate(num1, num2);
                    operand.push(result);
                    operator.pop();
                }
            }
            operator.push(component);
        }

        while (!operator.isEmpty()) {
            OperatorType currentOperator = operator.pop();
            int num2 = operand.pop();
            int num1 = operand.pop();
            int result = currentOperator.applyCalculate(num1, num2);
            operand.push(result);
        }

        return String.valueOf(operand.pop());
    }
}


