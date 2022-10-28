package app.validator;

import app.calculator.Select;

// 사용자 입력값을 검증합니다.
public class InputValidator {

    // 처음 어떤 작업을 할지 선택하는 입력값을 검증합니다.
    public boolean validateSelectInput(Select selectInput) {
        return selectInput == Select.LOOK_UP || selectInput == Select.CALCULATE || selectInput == Select.EXIT;
    }

    // 올바른 연산식인지 검증합니다.
    public boolean validateCalculateInputValue(String calculateInput) {
        calculateInput = calculateInput.replaceAll(RegexConstant.WHITESPACE, "");
        return isNumberAndOperator(calculateInput) && isCorrectExpression(calculateInput);
    }

    // 숫자와 올바른 연산자로 구성되어 있는지 정규식을 사용하여 검증합니다.
    private boolean isNumberAndOperator(String calculateInput) {

        for (String element : calculateInput.split("")) {
            if (!element.matches(RegexConstant.CORRECT_EXPRESSION)) return false;
        }

        return true;
    }

    // 올바른 연산식의 조합으로 구성되어 있는지 검증합니다.
    private boolean isCorrectExpression(String calculateInput) {

        int numberCount = 0;
        int operatorCount = 0;
        boolean isNum = false;

        for (char element : calculateInput.toCharArray()) {
            if (Character.isDigit(element)) {
                if (!isNum) {
                    isNum = true;
                    numberCount++;
                }
            } else {
                isNum = false;
                operatorCount++;
            }
        }

        return numberCount - 1 == operatorCount;
    }
}
