package com.programmers.model;

import com.programmers.util.Operators;
import com.programmers.util.PostfixConverter;
import com.programmers.util.StringUtil;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private final String formula;

    public Calculator(String formula) {
        this.formula = formula;
    }

    public long calculate(String formula) {
        List<String> postfix = PostfixConverter.convert(formula);
        return calculatePostfixFormula(postfix);
    }

    private long calculatePostfixFormula(List<String> formula) {
        Stack<Long> stack = new Stack<>();
        for (String numOrOperator : formula) {
            if (StringUtil.isNumber(numOrOperator)) {
                stack.push(StringUtil.convertStringToLong(numOrOperator));
            } else {
                Long num2 = stack.pop();
                Long num1 = stack.pop();
                stack.push(Operators.calculate(numOrOperator, num1, num2));
            }
        }
        return stack.pop();
    }

}
