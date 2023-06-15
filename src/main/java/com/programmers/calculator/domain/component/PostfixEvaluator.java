package com.programmers.calculator.domain.component;

import com.programmers.calculator.constant.RegexEnum;
import com.programmers.calculator.domain.core.Operator;
import com.programmers.calculator.domain.vo.CalculationResult;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class PostfixEvaluator implements Evaluator {

    @Override
    public CalculationResult evaluate(List<String> convertedExpression) {
        Stack<CalculationResult> operandStack = new Stack<>();

        for (String token : convertedExpression) {
            if (RegexEnum.isNumeric(token)) {
                operandStack.push(new CalculationResult(new BigDecimal(token)));
                continue;
            }

            if (operandStack.size() < 2) {
                throw new IllegalArgumentException("잘못된 수식입니다.");
            }

            CalculationResult operand2 = operandStack.pop();
            CalculationResult operand1 = operandStack.pop();
            CalculationResult result = Operator.of(token.charAt(0)).getFunction().apply(operand1, operand2);
            operandStack.push(result);
        }

        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("잘못된 수식입니다.");
        }

        return operandStack.pop();
    }
}
