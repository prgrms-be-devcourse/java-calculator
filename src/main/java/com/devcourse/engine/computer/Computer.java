package com.devcourse.engine.computer;

import com.devcourse.engine.exception.InvalidInputException;
import com.devcourse.engine.model.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.devcourse.engine.exception.InvalidInputException.INVALID_EXPRESSION;

public class Computer {





    public double compute(List<String> expression) {
        Stack<Double> stack = new Stack<>();

        for (String exp : expression) {
            if (Operator.isOperator(exp)) {
                stack.push(Operator.getOperator(exp).calculate(stack.pop(), stack.pop()));
            } else {
                stack.push(Double.parseDouble(exp));
            }
        }

        return stack.pop();
    }
}
