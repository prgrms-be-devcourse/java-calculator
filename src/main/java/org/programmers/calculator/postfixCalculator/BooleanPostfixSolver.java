package org.programmers.calculator.postfixCalculator;

import org.programmers.calculator.TypeChecker.BooleanTypeChecker;
import org.programmers.calculator.TypeChecker.TypeChecker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BooleanPostfixSolver implements PostfixSolver {

    private BooleanTypeChecker typeChecker;
    private BooleanCalculator calculator;

    public BooleanPostfixSolver(TypeChecker typeChecker) {
        this.typeChecker = (BooleanTypeChecker) typeChecker;
        this.calculator = new BooleanCalculator();
    }

    public String solve(List<String> postfixExpression) {
        Deque<String> calculationStack = new ArrayDeque<>();

        for (String s : postfixExpression) {
            if (typeChecker.isOperand(s)) {
                calculationStack.push(s);
            } else if (typeChecker.isOperator(s)) {
                String y = calculationStack.pop();
                if (typeChecker.isOperatorWithOneOperand(s)) {
                    calculationStack.push(callOperation(s, y));
                }
                else {
                    String x = calculationStack.pop();
                    calculationStack.push(callOperation(s, x, y));
                }
            }
        }

        return calculationStack.pop();
    }

    private String callOperation(String operator, String operand) {
        if (operator.equals("!")) {
            return calculator.negation(operand);
        }
        throw new IllegalArgumentException("연산자를 잘못 입력하셨습니다.");
    }

    private String callOperation(String operator, String operandA, String operandB) {
        if (operator.equals("&")) {
            return calculator.conjunction(operandA, operandB);
        }
        if (operator.equals("|")) {
            return calculator.disjunction(operandA, operandB);
        }
        if (operator.equals("->")) {
            return calculator.materialImplication(operandA, operandB);
        }
        throw new IllegalArgumentException("연산자를 잘못 입력하셨습니다.");
    }
}
