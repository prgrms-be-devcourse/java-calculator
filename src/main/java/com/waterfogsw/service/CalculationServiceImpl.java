package com.waterfogsw.service;

import com.waterfogsw.converter.Converter;
import com.waterfogsw.domain.Operator;
import com.waterfogsw.tokenizer.Tokenizer;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Stack;

@AllArgsConstructor
public class CalculationServiceImpl implements CalculationService {

    private final Tokenizer tokenizer;
    private final Converter converter;

    @Override
    public String getResult(String expr) {
        List<String> infixTokens = tokenizer.parse(expr);
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
        Long ret = switch (op) {
            case "+" -> ly + lx;
            case "-" -> ly - lx;
            case "*" -> ly * lx;
            default -> ly / lx;
        };

        return String.valueOf(ret);
    }

}
