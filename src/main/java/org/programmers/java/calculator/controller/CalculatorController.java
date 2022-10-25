package org.programmers.java.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;
import org.programmers.java.calculator.util.verifiaction.FormulaVerification;

import java.util.*;

@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorServiceImpl calculatorServiceImpl;

    public String record() {
        return calculatorServiceImpl.record();
    }

    public String calculate(String input) {
        Optional<String> cache = calculatorServiceImpl.find(input);
        if (cache.isPresent()) {
            return cache.get();
        } else {
            String answer = getAnswer(input);
            calculatorServiceImpl.save(input, answer);
            return answer;
        }
    }

    private String getAnswer(String input) {
        List<String> token = parse(input);
        String answer = toPostfixNotation(token);
        return answer;
    }

    private List<String> parse(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));
        FormulaVerification.formulaVerifiaction(tokens);
        return tokens;
    }

    private String toPostfixNotation(List<String> tokens) {
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        HashMap<String, Integer> inP = new HashMap<>();
        inP.put("(", 0);
        inP.put("+", 1);
        inP.put("-", 1);
        inP.put("*", 2);
        inP.put("/", 2);

        HashMap<String, Integer> outP = new HashMap<>();
        outP.put("+", 1);
        outP.put("-", 1);
        outP.put("*", 2);
        outP.put("/", 2);
        outP.put("(", 3);

        ArrayList<String> arr = new ArrayList<>();

        for (String token : tokens) {
            if (token.equals("(") || token.equals("/") || token.equals("*") || token.equals("-") || token.equals("+")) {
                if (stack.isEmpty()) {
                    stack.push(token);
                } else {
                    if (inP.get(stack.peek()) < outP.get(token)) {
                        stack.push(token);
                    } else {
                        while (!stack.isEmpty()) {
                            if (inP.get(stack.peek()) < outP.get(token)) {
                                stack.push(token);
                                break;
                            }
                            arr.add(stack.pop());
                        }
                    }
                }
            } else if (token.equals(")")) {
                while (!stack.isEmpty()) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        break;
                    }
                    arr.add(stack.pop());
                }
            } else {
                arr.add(token);
            }
        }
        while (!stack.isEmpty()) {
            arr.add(stack.pop());
        }

        int len = arr.size();
        Stack<Double> sum = new Stack<>();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals("+")) {
                double p;
                double q;
                q = sum.pop();
                p = sum.pop();
                sum.add(p + q);
            } else if (arr.get(i).equals("-")) {
                double p;
                double q;
                q = sum.pop();
                p = sum.pop();
                sum.add(p - q);
            } else if (arr.get(i).equals("*")) {
                double p;
                double q;
                q = sum.pop();
                p = sum.pop();
                sum.add(p * q);
            } else if (arr.get(i).equals("/")) {
                double p;
                double q;
                q = sum.pop();
                p = sum.pop();
                sum.add(p / q);
            } else {
                sum.add(Double.parseDouble(arr.get(i)));
            }
        }
        return sum.pop().toString();
    }
}
