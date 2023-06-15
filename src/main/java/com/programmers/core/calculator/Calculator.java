package com.programmers.core.calculator;

import com.programmers.core.Operators;
import com.programmers.core.converter.Converter;
import com.programmers.core.data.CalculationRequest;
import com.programmers.core.data.CalculationResult;
import com.programmers.util.StringUtil;

import java.util.List;
import java.util.Stack;

public class Calculator implements AbstractCalculator {
    private final Converter converter;

    public Calculator(Converter converter) {
        this.converter = converter;
    }

    @Override
    public CalculationResult calculate(CalculationRequest request) {
        String formula = request.getFormula();
        List<String> postfix = converter.convert(formula);
        long result = calculatePostfixFormula(postfix);
//        request.updateResult(result);
//        return request;
        return new CalculationResult(formula, result);
    }

    private long calculatePostfixFormula(List<String> postfix) {
        Stack<Long> stack = new Stack<>();
        for (String token : postfix) {
            if (StringUtil.isNumber(token)) {
                stack.push(StringUtil.convertStringToLong(token));
            } else {
                calculateTop(stack, token);
            }
        }
        return stack.pop();
    }

    private void calculateTop(Stack<Long> stack, String token) {
        Long num2 = stack.pop();
        Long num1 = stack.pop();
        stack.push(Operators.calculate(token, num1, num2));
    }
}
