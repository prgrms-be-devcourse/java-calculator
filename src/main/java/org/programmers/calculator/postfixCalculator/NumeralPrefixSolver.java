package org.programmers.calculator.postfixCalculator;

import org.programmers.calculator.TypeChecker.TypeChecker;
import org.programmers.calculator.configuration.Component;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;

import java.util.List;
import java.util.Stack;

@Component
public class NumeralPrefixSolver implements Solver {

    private NumeralTypeChecker typeChecker;
    private NumeralCalculator calculator;

    public NumeralPrefixSolver(TypeChecker typeChecker, NumeralCalculator calculator) {
        this.typeChecker = (NumeralTypeChecker) typeChecker;
        this.calculator = calculator;
    }

    public String solve(List<String> postfixExpression) {
        Stack<String> calculationStack = new Stack();

        for (int i = 0; i < postfixExpression.size(); i++) {
            String s = postfixExpression.get(i);
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

    private String callOperation(String operator, String operandA, String operandB) {
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
            return calculator.division(operandA, operandB);
        }
        throw new IllegalArgumentException("연산자를 잘못 입력하셨습니다.");
    }
}
