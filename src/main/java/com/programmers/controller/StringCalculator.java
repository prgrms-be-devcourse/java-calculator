package com.programmers.controller;

import com.programmers.domain.CalculatorType;
import com.programmers.domain.Formula;
import com.programmers.domain.Result;
import com.programmers.view.InputView;
import com.programmers.view.ResultView;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TERMINAL_NUMBER = 3;
    private static final char BLANK = ' ';
    private static final int INTERVAL = 2;
    private static final String ADD = "+";
    private static final String SUBTRACT = " - ";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final int WRONG_NUMBER = -1;

    private final Result calculatorResult;

    public StringCalculator(Result calculatorResult) {
        this.calculatorResult = calculatorResult;
    }

    public void play() {
        while (true) {
            ResultView.selectMenuView();
            int selectNum = InputView.selectMenu();

            if (selectNum == WRONG_NUMBER) {
                continue;
            }

            if (selectNum == TERMINAL_NUMBER) {
                break;
            }

            if (selectNum == ONE) {
                ResultView.inquire(calculatorResult.getResult());
                continue;
            }

            String inputString = InputView.inputString();

            int result = calculateAll(inputString);
            calculatorResult.addResult(new Formula(inputString, result));
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

        CalculatorType type = CalculatorType.selectType(inputString.charAt(index));
        int result = type.calculate(numOne, numTwo);

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
