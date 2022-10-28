package com.programmers.calculator.processor;

import com.programmers.calculator.entity.Operation;
import com.programmers.calculator.io.Console;
import com.programmers.calculator.storage.OperationRepository;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator {
    private final Operator operator = new Operator();
    private Deque<String> deque = new LinkedList<>();

    public Operation calculate(String formula, String[] parsedInputStr) {
        int notationSize = parsedInputStr.length;
        String[] postfixNotation = new String[notationSize];
        int postfixIndex = 0;

        /** 후위표현식으로의 변환 **/
        for (int i = 0; i < parsedInputStr.length; i++) {
            if (i % 2 == 0) { // 숫자
                postfixNotation[postfixIndex] = parsedInputStr[i];
                postfixIndex += 1;
            } else { // 연산자
                while(!deque.isEmpty() && operator.getOperatorPriority(deque.getLast()) >= operator.getOperatorPriority(parsedInputStr[i])) {
                    postfixNotation[postfixIndex] = deque.pollLast();
                    postfixIndex += 1;
                }
                deque.addLast(parsedInputStr[i]);
            }
        }
        while(!deque.isEmpty()) {
            postfixNotation[postfixIndex] = deque.pollLast();
            postfixIndex += 1;
        }

        /** 후위표현식을 이용한 계산 **/
        for (int i = 0; i < postfixNotation.length; i++) {
            if (Pattern.matches(Validator.NUMBER_REGEX, postfixNotation[i])) { // 숫자
                deque.addLast(postfixNotation[i]);
            } else { // 연산자
                String lastNumber = deque.pollLast();
                String firstNumber = deque.pollLast();

                Double result = operator.getOperatorCalculation(postfixNotation[i]).apply(Double.parseDouble(firstNumber), Double.parseDouble(lastNumber));
                deque.addLast(result.toString());
            }
        }

        String totalStr = deque.pollLast();
        double doubleTotal = Double.parseDouble(totalStr);
        int integerTotal = (int) doubleTotal;

        Operation operation;

        if (integerTotal == doubleTotal) { // 소수점 없이 저장.
            operation = new Operation(formula, Integer.toString(integerTotal));
        } else {
            operation = new Operation(formula, Double.toString(Math.round(doubleTotal*100)/100.0));
        }

        return operation;
    }

    public String[] parseFolmula(String inputStr) {
        return inputStr.trim().split("\\s+");
    }

    public Operation excute(String inputString) {
        String[] parsedInputStr = parseFolmula(inputString);

        try {
            Validator.isRightSpacing(parsedInputStr);
            Validator.isRightOperatorAndNumbers(parsedInputStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return calculate(inputString, parsedInputStr);
    }

}
