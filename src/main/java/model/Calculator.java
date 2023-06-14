package model;

import exception.NoSuchOperatorException;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    private final Deque<Integer> operandStack;
    private final Deque<Operator> operatorStack;

    public Calculator() {
        this.operandStack = new ArrayDeque<>();
        this.operatorStack = new ArrayDeque<>();
    }

    public String calculate(String expression) throws RuntimeException {
        for (String expressionComponent : expression.split("")) {
            if (Character.isDigit(expressionComponent.charAt(0))) {
                operandStack.push(Integer.parseInt(expressionComponent));
                continue;
            }
            calculateIfOperatorNotEmpty(expressionComponent);
        }

        return makeFinalCalculation();
    }

    private void calculateIfOperatorNotEmpty(String expressionComponent) throws NoSuchOperatorException {
        Operator currentOperator = Operator.getOperator(expressionComponent);
        if (!operatorStack.isEmpty()) {
            calculateByPrecedence(currentOperator);
        }
        operatorStack.push(currentOperator);
    }

    private void calculateByPrecedence(Operator currentOperator) {
        Operator peekOperator = operatorStack.peek();
        if (peekOperator == null) {
            throw new NoSuchOperatorException("[ERROR] 연산자 스택이 비어있습니다.");
        }

        if (peekOperator.getPrecedence() >= currentOperator.getPrecedence()) {
            int rightNumber = operandStack.pop();
            int leftNumber = operandStack.pop();
            operandStack.push(peekOperator.applyCalculate(leftNumber, rightNumber));
            operatorStack.pop();
        }
    }

    private String makeFinalCalculation() {
        Operator currentOperator = operatorStack.pop();
        int rightNumber = operandStack.pop();
        int leftNumber = operandStack.pop();

        return String.valueOf(currentOperator.applyCalculate(leftNumber, rightNumber));
    }
}


