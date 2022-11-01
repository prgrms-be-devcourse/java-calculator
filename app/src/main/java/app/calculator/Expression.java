package app.calculator;

import app.exception.AbnormalExpressionException;
import app.validator.RegexConstant;

public class Expression {

    private final String inputExpression;

    public Expression(String inputExpression) {
        this.inputExpression = inputExpression;
        validateInputExpression();
    }

    public String getExpressionValue() {
        return this.inputExpression;
    }

    // 올바른 연산식인지 검증합니다.
    public void validateInputExpression() {
        String removeWhiteSpaceInputExpression = inputExpression.replaceAll(RegexConstant.WHITESPACE, "");
        if (!isNumberAndOperator(removeWhiteSpaceInputExpression) || !isCorrectExpression(removeWhiteSpaceInputExpression)) {
            throw new AbnormalExpressionException();
        }
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
