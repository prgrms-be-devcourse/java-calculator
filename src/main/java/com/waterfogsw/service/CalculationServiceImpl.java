package com.waterfogsw.service;

import com.waterfogsw.converter.Converter;
import com.waterfogsw.domain.Operator;
import com.waterfogsw.parser.Parser;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Stack;

@AllArgsConstructor
public class CalculationServiceImpl implements CalculationService {

    private final Parser parser;
    private final Converter converter;

    @Override
    public String getResult(String expr) {
        List<String> infixTokens = parser.parse(expr);
        List<String> postfixTokens = converter.convert(infixTokens);

        Stack<String> stack = new Stack<>();

        for (String token : postfixTokens) {
            if (!Operator.isOperator(token)) {
                stack.add(token);
            } else {
                String x = stack.pop();
                String y = stack.pop();

                String result = calculate(x, y, token);
                stack.add(result);
            }
        }

        return stack.pop();
    }


    private String calculate(String x, String y, String op) {
        Long lx = Long.parseLong(x);
        Long ly = Long.parseLong(y);
        Long ret = 0L;

        switch (op) {
            case "+":
                ret = ly + lx;
                break;
            case "-":
                ret = ly - lx;
                break;
            case "*":
                ret = ly * lx;
                break;
            default:
                ret = ly / lx;
                break;
        }
        return String.valueOf(ret);
    }

}
