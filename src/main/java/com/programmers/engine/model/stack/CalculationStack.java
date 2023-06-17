package com.programmers.engine.model.stack;

import com.programmers.engine.model.confirmation.Confirmation;
import com.programmers.engine.model.operation.Operator;

import java.util.List;
import java.util.Stack;

public class CalculationStack {

    private final Stack<Integer> operandStack;
    private final Stack<String> operatorStack;
    private final Confirmation confirmation;

    public CalculationStack(Stack<Integer> operandStack, Stack<String> operatorStack, Confirmation confirmation) {
        this.operandStack = operandStack;
        this.operatorStack = operatorStack;
        this.confirmation = confirmation;
    }

    public Integer popAnswer(List<String> operatorsAndOperands) {
        for (String element : operatorsAndOperands) {
            pushOperand(element);
            pushOperator(element);
        }
        calculateRemainStackValue();
        return operandStack.pop();
    }

    private void calculateRemainStackValue() {
        while (!operatorStack.empty()) {
            Integer calculationResult = getPerformFourArithmeticOperations(operatorStack.pop(), operandStack.pop(), operandStack.pop());
            operandStack.push(calculationResult);
        }
    }

    private void pushOperand(String element) {
        if (confirmation.isOperand(element)) {
            operandStack.push(Integer.valueOf(element));
        }
    }

    private void pushOperator(String element) {
        if (confirmation.isOperator(element)) {
            pushCalculationResult(operatorStack, operandStack, element);
            operatorStack.push(element);
        }
    }

    private void pushCalculationResult(Stack<String> operatorsStack, Stack<Integer> operandsStack, String element) {
        while (!operatorsStack.empty() && isComparePriorities(operatorsStack.peek(), element)) {
            Integer calculationResult = getPerformFourArithmeticOperations(operatorsStack.pop(), operandsStack.pop(), operandsStack.pop());
            operandsStack.push(calculationResult);
        }
    }

    private boolean isComparePriorities(String operator, String element) {
        if ((operator.equals(Operator.MULTIPLY.getOperator())) || operator.equals(Operator.DIVIDE.getOperator()) && (element.equals(Operator.PLUS.getOperator()) || element.equals(Operator.MINUS.getOperator()))) {
            return true;
        }
        return false;
    }

    private Integer getPerformFourArithmeticOperations(String operator, Integer operand1, Integer operand2) {
        return Operator.getOperator(operator).calculate(operand2, operand1);
    }
}
