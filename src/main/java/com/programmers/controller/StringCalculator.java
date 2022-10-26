package com.programmers.controller;

import com.programmers.domain.CalculatorType;
import com.programmers.domain.Result;
import com.programmers.view.InputView;
import com.programmers.view.ResultView;

public class StringCalculator {
    private final int ZERO = 0;
    private final int ONE = 1;
    private final int TERMINAL_NUMBER = 3;
    private final char BLANK = ' ';
    private final int INTERVAL = 2;
    private final String ADD = "+";
    private final String SUBTRACT = " - ";
    private final String MULTIPLY = "*";
    private final String DIVIDE = "/";

    private Result calculatorResult;

    public StringCalculator(Result calculatorResult) {
        this.calculatorResult = calculatorResult;
    }

    public void play() {
        while (true) {
            int selectNum = InputView.selectMenu();

            if (selectNum == TERMINAL_NUMBER) {
                break;
            }

            if (selectNum == ONE) {
                ResultView.inquire(calculatorResult.getResult());
                continue;
            }

            String inputString = InputView.inputString();

            int result = calculateAll(inputString);
            calculatorResult.addResult(inputString, result);
            ResultView.calculateResult(result);
        }
    }

    private int calculateAll(String inputString) {
        while (inputString.contains(MULTIPLY) || inputString.contains(DIVIDE)) {
            int priorityIndex = findSignIndex(inputString, MULTIPLY, DIVIDE);
            inputString = calculateOne(inputString, priorityIndex);
        }

        while (inputString.contains(ADD) || inputString.contains(SUBTRACT)) {
            int priorityIndex = findSignIndex(inputString, ADD, SUBTRACT);
            inputString = calculateOne(inputString, priorityIndex);
        }

        return Integer.parseInt(inputString);
    }

    private String calculateOne(String inputString, int index) {
        int indexOne = (index - INTERVAL);
        int indexTwo = (index + INTERVAL);

        while (indexOne >= ZERO && inputString.charAt(indexOne) != BLANK) {
            indexOne--;
        }
        while (indexTwo < inputString.length() && inputString.charAt(indexTwo) != BLANK) {
            indexTwo++;
        }
        indexOne++;

        int numOne = Integer.parseInt(inputString.substring(indexOne, index - ONE));
        int numTwo = Integer.parseInt(inputString.substring(index + INTERVAL, indexTwo));

        int result = CalculatorType.selectType(inputString.charAt(index)).calculate(numOne, numTwo);

        return inputString.substring(ZERO, indexOne) + result + inputString.substring(indexTwo);
    }

    private int findSignIndex(String inputString, String signOne, String signTwo) {
        int signOneIndex = findIndex(inputString, signOne);
        int signTwoIndex = findIndex(inputString, signTwo);

        return Math.min(signOneIndex, signTwoIndex);
    }

    private int findIndex(String inputString, String sign) {
        if (inputString.contains(sign)) {
            int result = inputString.indexOf(sign);
            return subtractProcessing(sign, result);
        }
        return Integer.MAX_VALUE;
    }

    private int subtractProcessing(String sign, int result) {
        if (sign.equals(SUBTRACT)) {
            return ++result;
        }
        return result;
    }
}
