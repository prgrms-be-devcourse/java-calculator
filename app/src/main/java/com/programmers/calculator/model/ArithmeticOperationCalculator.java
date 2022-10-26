package com.programmers.calculator.model;

import com.programmers.calculator.domain.OperationResult;

import java.util.*;
import java.util.regex.Pattern;

public class ArithmeticOperationCalculator implements Calculator{

    private final Map<String, Integer> priority = new HashMap<>() {{
        put("*", 2);
        put("/", 2);
        put("+", 1);
        put("-", 1);
    }};
    private Deque<String> stack = new LinkedList<>();

    @Override
    public Optional<OperationResult> calculate(String formula, String[] parsedInputStr) {
        int notationSize = parsedInputStr.length;
        String[] postfixNotation = new String[notationSize];
        int postfixIndex = 0;

        for (int i = 0; i < parsedInputStr.length; i++) {
            if (i % 2 == 0) { // 숫자
                postfixNotation[postfixIndex] = parsedInputStr[i];
                postfixIndex += 1;
            } else { // 연산자
                while(!stack.isEmpty() && priority.get(stack.getLast()) >= priority.get(parsedInputStr[i])) {
                    postfixNotation[postfixIndex] = stack.pollLast();
                    postfixIndex += 1;
                }
                stack.addLast(parsedInputStr[i]);
            }
        }
        while(!stack.isEmpty()) {
            postfixNotation[postfixIndex] = stack.pollLast();
            postfixIndex += 1;
        }


        for (int i = 0; i < postfixNotation.length; i++) {
            if (Pattern.matches(Validator.NUMBER_REGEX, postfixNotation[i])) { // 숫자
                stack.addLast(postfixNotation[i]);
            } else { // 연산자
                String lastNumber = stack.pollLast();
                String firstNumber = stack.pollLast();

                Double result = null;
                if (postfixNotation[i].equals("+")) {
                    result = plus(Double.parseDouble(firstNumber), Double.parseDouble(lastNumber));
                } else if (postfixNotation[i].equals("-")) {
                    result = minus(Double.parseDouble(firstNumber), Double.parseDouble(lastNumber));
                } else if (postfixNotation[i].equals("*")) {
                    result = multiplication(Double.parseDouble(firstNumber), Double.parseDouble(lastNumber));
                } else if (postfixNotation[i].equals("/")) {
                    result = division(Double.parseDouble(firstNumber), Double.parseDouble(lastNumber))
                            .orElse(null);
                }

                if (result == null) return Optional.empty();

                stack.addLast(result.toString());
            }
        }

        String totalStr = stack.pollLast();
        double doubleTotal = Double.parseDouble(totalStr);
        int integerTotal = (int) doubleTotal;


        OperationResult operationResult = new OperationResult();
        operationResult.setFormula(formula);

        if (integerTotal == doubleTotal) { // 소수점 없이 저장.
            operationResult.setResult(Integer.toString(integerTotal));
        } else {
            operationResult.setResult(Double.toString(Math.round(doubleTotal*100)/100.0));
        }

        return Optional.ofNullable(operationResult);
    }
}
