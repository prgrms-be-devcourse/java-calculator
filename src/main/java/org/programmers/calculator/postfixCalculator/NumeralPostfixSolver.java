package org.programmers.calculator.postfixCalculator;

import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.TypeChecker.TypeChecker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class NumeralPostfixSolver implements Solver {

    private NumeralTypeChecker typeChecker;
    private NumeralCalculator calculator;

    public NumeralPostfixSolver(TypeChecker typeChecker, NumeralCalculator calculator) {
        this.typeChecker = (NumeralTypeChecker) typeChecker;
        this.calculator = calculator;
    }

    public String solve(List<String> postfixExpression) {
        Deque<String> calculationStack = new ArrayDeque<>();

        for (String s : postfixExpression) {
            if (typeChecker.isOperand(s)) {
                calculationStack.push(s);
            } else if (typeChecker.isOperator(s)) {
                String y = calculationStack.pop();
                String x = calculationStack.pop();
                calculationStack.push(callOperation(s, x, y));
            }
        }

        return calculationStack.pop();
    }

    private String callOperation(String operator, String operandA, String operandB) throws ArithmeticException {
        if (operator.equals("+")) {
            return calculator.plus(operandA, operandB);
        }
        if (operator.equals("-")) {
            return calculator.minus(operandA, operandB);
        }
        if (operator.equals("*")) {
            return calculator.multiply(operandA, operandB);
        }
        if (operator.equals("/")) {
            return calculator.divide(operandA, operandB);
        }
        throw new IllegalArgumentException("연산자를 잘못 입력하셨습니다.");
    }
}
