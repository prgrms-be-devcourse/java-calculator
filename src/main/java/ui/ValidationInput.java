package ui;

import exception.NotEquationFormatException;
import exception.NotMenuFormatExcpetion;
import util.Brackets;
import util.Menu;
import util.OperatorMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidationInput {
    public static void checkMenuNumber(Menu menu) {
        if (menu == Menu.EMPTY) {
            throw new NotMenuFormatExcpetion();
        }
    }

    public static void isEmpty(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new NotMenuFormatExcpetion();
        }
    }

    public static void checkEquation(String userInput) {
        String[] inputDatas = userInput.split(" ");

        if (!isOddNumber(inputDatas.length)) {
            throw new NotEquationFormatException();
        }

        checkCorrectBracket(inputDatas);
        checkFormat(inputDatas);
    }

    private static void checkCorrectBracket(String[] inputDatas) {
        Stack<String> correctBracket = new Stack<>();
        for (String inputData : inputDatas) {
            if (isBracket(inputData)) {
                addBracket(correctBracket, inputData);
            }
        }

        if (!correctBracket.isEmpty()) {
            throw new NotEquationFormatException();
        }
    }
    private static boolean isBracket(String input) {
        return Brackets.isOpenBrackets(input) || Brackets.isCloseBrackets(input);
    }
    private static void addBracket(Stack<String> correctBracket, String input) {
        if (correctBracket.isEmpty()) {
            correctBracket.add(input);
            return;
        }

        if (Brackets.isMatch(correctBracket.peek(), input)) {
            correctBracket.pop();
            return;
        }

        correctBracket.add(input);
    }
    private static void checkFormat(String[] inputDatas) {
        for (int index = 0; index < inputDatas.length; index++) {
            String inputData = inputDatas[index];

            index = inputLoop(inputDatas,index);
        }

    }

    private static int inputLoop(String[] inputDatas, int startIndex) {
        boolean haveNumber = false;
        int curIndex=0;

        while (startIndex < inputDatas.length) {
            if (Brackets.isCloseBrackets(inputDatas[startIndex])) {
                break;
            }

            startIndex = eachInput(inputDatas, startIndex, curIndex);

            startIndex++; curIndex++;
        }

        if (!haveNumber) {
            throw new NotEquationFormatException();
        }

        return startIndex;
    }

    private static int eachInput(String[] inputDatas, int index, int curIndex) {
        String inputData = inputDatas[index];
        if (Brackets.isOpenBrackets(inputData)) {
            return inputLoop(inputDatas, index+1);
        }

        if (isOddNumber(curIndex)) {
            checkOperation(inputData);
            return index;
        }
        checkNumber(inputData);
        return index;
    }

    private static boolean isOddNumber(int size) {
        return size % 2 != 0;
    }

    private static void checkNumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException exception) {
            throw new NotEquationFormatException(exception.getMessage());
        }
    }

    private static void checkOperation(String input) {
        if (!OperatorMap.contains(input)) {
            throw new NotEquationFormatException();
        }
    }
}