package com.programmers;

import com.programmers.core.Converter;
import com.programmers.core.Operators;
import com.programmers.core.PostfixConverter;
import com.programmers.util.StringUtil;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private final Converter converter;
    private final String formula;

    public Calculator(String formula) {
        this.formula = formula;
        this.converter = new PostfixConverter();
    }

    public long calculate(String formula) {
        List<String> postfix = converter.convert(formula);
        return calculatePostfixFormula(postfix);
    }

    private long calculatePostfixFormula(List<String> formula) {
        Stack<Long> stack = new Stack<>();
        for (String token : formula) {
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
