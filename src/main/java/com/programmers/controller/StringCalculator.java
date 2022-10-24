package com.programmers.controller;

import com.programmers.domain.CalculatorResult;
import com.programmers.domain.CalculatorType;
import com.programmers.view.InputView;
import com.programmers.view.ResultView;

public class StringCalculator {
    private static CalculatorResult calculatorResult = new CalculatorResult();

    public void play() {
        while (true) {
            int selectNum = InputView.selectMenu();

            if (selectNum == 1) {
                ResultView.inquire(calculatorResult.getCalculatorResult());
                continue;
            }
            String inputString = InputView.inputString();

            int result = calculateAll(inputString);
            calculatorResult.addResult(inputString, result);
            ResultView.calculateResult(result);
        }
    }

    private int calculateAll(String inputString) {

        while (inputString.contains("*") || inputString.contains("/")) {
            int priorityIndex = findSign(inputString, "*", "/");
            inputString = calculateOne(inputString, priorityIndex);
        }

        while (inputString.contains("+") || inputString.contains(" - ")) {
            int priorityIndex = findSign(inputString, "+", " - ");
            inputString = calculateOne(inputString, priorityIndex);
        }
        System.out.println("resultInputString: " + inputString);

        return Integer.parseInt(inputString);
    }

    private String calculateOne(String inputString, int index) {
        int indexOne = (index - 2);
        int indexTwo = (index + 2);

        while (indexOne >= 0 && inputString.charAt(indexOne) != ' ') {
            indexOne--;
        }
        while (indexTwo < inputString.length() && inputString.charAt(indexTwo) != ' ') {
            indexTwo++;
        }

        int num1 = Integer.parseInt(inputString.substring(indexOne + 1, index - 1));
        int num2 = Integer.parseInt(inputString.substring(index + 2, indexTwo));

        CalculatorType currentType = CalculatorType.selectType(inputString.charAt(index));

        int result = currentType.calculate(num1, num2);

        return inputString.substring(0, indexOne + 1) + result + inputString.substring(indexTwo);

    }

    private int findSign(String inputString, String sign1, String sign2) {
        int sign1_Index = inputString.indexOf(sign1);
        int sign2_Index = inputString.indexOf(sign2);
        String selectSign;
        int index;

        if (sign1_Index != -1 && sign2_Index != -1) {
            if (sign1_Index < sign2_Index) {
                selectSign = sign1;
                index = sign1_Index;
            }
            selectSign = sign2;
            index = sign2_Index;
        } else {
            if (sign1_Index != -1) {
                selectSign = sign1;
                index = sign1_Index;
            } else {
                selectSign = sign2;
                index = sign2_Index;
            }
        }
        if (selectSign.equals(" - ")) {
            return (++index);
        }
        return index;
    }

}
