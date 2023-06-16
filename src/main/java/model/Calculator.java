package model;

import exception.IllegalExpressionException;
import exception.NoSuchOperatorException;
import util.CalculatorUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class Calculator {
    private final Deque<Integer> operandStack;
    private final Deque<Operator> operatorStack;

    public Calculator() {
        this.operandStack = new ArrayDeque<>();
        this.operatorStack = new ArrayDeque<>();
    }

    public String calculate(String expression) throws RuntimeException {
        if (expression == null || expression.equals("")) {
            throw new IllegalExpressionException("[ERROR] 비어있는 식이 들어왔습니다.");
        }

        for (String expressionComponent : expression.split(" ")) {
            if (CalculatorUtils.isStringNumber(expressionComponent)) {
                operandStack.push(CalculatorUtils.parseStringToInteger(expressionComponent));
                continue;
            }
            calculateIfOperatorNotEmpty(expressionComponent);
        }

        return makeFinalCalculation();
    }

    private void calculateIfOperatorNotEmpty(String expressionComponent) throws RuntimeException {
        if (expressionComponent.length() > 1) {
            throw new NoSuchOperatorException("[ERROR] 옳지 않은 연산자입니다.");
        }

        Operator currentOperator = Operator.getOperator(expressionComponent.charAt(0));
        if (!operatorStack.isEmpty()) {
            calculateByPrecedence(currentOperator);
        }
        operatorStack.push(currentOperator);
    }

    private void calculateByPrecedence(Operator currentOperator) {
        Optional<Operator> peekOperator = Optional.ofNullable(operatorStack.peek());
        peekOperator.ifPresentOrElse((operator -> {
            if (operator.getPrecedence() < currentOperator.getPrecedence()) {
                return;
            }
            if (operandStack.size() < 2) {
                throw new IllegalExpressionException("[ERROR] 피연산자 스택에 수가 부족합니다.");
            }

            int rightNumber = operandStack.pop();
            int leftNumber = operandStack.pop();
            operandStack.push(operator.applyCalculate(leftNumber, rightNumber));
            operatorStack.pop();
        }), () -> {
            throw new NoSuchOperatorException("[ERROR] 연산자 스택이 비어있습니다.");
        });
    }

    private String makeFinalCalculation() {
        if (operatorStack.size() != 1 || operandStack.size() != 2) {
            throw new IllegalExpressionException("[ERROR] 잘못된 식이 입력됐습니다.");
        }

        Operator currentOperator = operatorStack.pop();
        int rightNumber = operandStack.pop();
        int leftNumber = operandStack.pop();
        return String.valueOf(currentOperator.applyCalculate(leftNumber, rightNumber));
    }
}


