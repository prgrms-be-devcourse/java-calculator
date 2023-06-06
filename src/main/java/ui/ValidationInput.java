package ui;

import exception.NotEquationFormatException;
import exception.NotMenuFormatExcpetion;
import util.Menu;
import util.OperatorMap;

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

        for (int inputIndex = 0; inputIndex < inputDatas.length; inputIndex++) {
            eachInput(inputDatas[inputIndex], inputIndex);
        }
    }

    private static void eachInput(String data, int index) {
        if (isOddNumber(index)) {
            checkOperation(data);
            return;
        }
        checkNumber(data);
    }

    private static boolean isOddNumber(int size) {
        return size % 2 != 0;
    }

    private static void checkNumber(String data) {
        try {
            Double.parseDouble(data);
        } catch (NumberFormatException exception) {
            throw new NotEquationFormatException(exception.getMessage());
        }
    }

    private static void checkOperation(String data) {
        if (!OperatorMap.contains(data)) {
            throw new NotEquationFormatException();
        }
    }
}

/*
* 1 + (2 * 3 * 4) + 5 / 7
* */