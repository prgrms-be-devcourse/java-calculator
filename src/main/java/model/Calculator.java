package model;

import exception.NoSuchOperatorException;
import util.CalculatorUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.function.Consumer;

public class Calculator {
    private final Deque<Integer> operandStack;
    private final Deque<Operator> operatorStack;

    public Calculator() {
        this.operandStack = new ArrayDeque<>();
        this.operatorStack = new ArrayDeque<>();
    }

    public String calculate(String expression) throws RuntimeException {
        for (String expressionComponent : expression.split(" ")) {
            if (CalculatorUtils.isStringNumber(expressionComponent)) {
                operandStack.push(CalculatorUtils.parseStringToInteger(expressionComponent));
                continue;
            }
            calculateIfOperatorNotEmpty(expressionComponent);
        }

        return makeFinalCalculation();
    }

    private void calculateIfOperatorNotEmpty(String expressionComponent) throws NoSuchOperatorException {
        Operator currentOperator = Operator.getOperator(expressionComponent.charAt(0));
        if (!operatorStack.isEmpty()) {
            calculateByPrecedence(currentOperator);
        }
        operatorStack.push(currentOperator);
    }

    private void calculateByPrecedence(Operator currentOperator) {
        Optional<Operator> peekOperator = Optional.ofNullable(operatorStack.peek());
        peekOperator.ifPresentOrElse(calculateConsumer(currentOperator), () -> {
            throw new NoSuchOperatorException("[ERROR] 연산자 스택이 비어있습니다.");
        });
    }

    private Consumer<Operator> calculateConsumer(Operator currentOperator) {
        return (operator) -> {
            if (operator.getPrecedence() >= currentOperator.getPrecedence()) {
                int rightNumber = operandStack.pop();
                int leftNumber = operandStack.pop();
                operandStack.push(operator.applyCalculate(leftNumber, rightNumber));
                operatorStack.pop();
            }
        };
    }

    private String makeFinalCalculation() {
        Operator currentOperator = operatorStack.pop();
        int rightNumber = operandStack.pop();
        int leftNumber = operandStack.pop();

        return String.valueOf(currentOperator.applyCalculate(leftNumber, rightNumber));
    }
}


