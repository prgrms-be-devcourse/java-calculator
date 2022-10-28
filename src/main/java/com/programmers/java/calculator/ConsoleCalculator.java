package com.programmers.java.calculator;


import com.programmers.java.calculator.parser.InfixToPostFixParser;
import com.programmers.java.data.MapRepository;
import com.programmers.java.data.Result;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ConsoleCalculator implements Calculator {

    private MapRepository store;
    private InfixToPostFixParser parser;


    public Double calculate(String expression) {
        if (store.contain(expression)) return store.getOneResult(expression);
        List<String> postFix = Arrays.stream(parser.parse(expression).split(" "))
                .filter(i -> !i.equals(""))
                .collect(Collectors.toList());
        Stack<Double> nums = new Stack<>();

        for (int i = 0; i < postFix.size(); i++) {
            String s = postFix.get(i);
            if (s.isBlank() || s.isEmpty()) continue;
            if (parser.isNum(s)) {
                nums.push(Double.parseDouble(s));
            } else {
                double num2 = nums.pop();
                double num1 = nums.pop();
                CalculateType type = CalculateType.getOperator(s);
                nums.push(type.doOperation(num1, num2, type));
            }
        }
        Double answer = nums.pop();
        store.save(new Result(expression, answer));
        return answer;
    }
}
