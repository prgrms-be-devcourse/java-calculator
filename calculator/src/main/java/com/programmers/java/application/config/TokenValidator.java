package com.programmers.java.application.config;

import com.programmers.java.application.exception.*;

import java.util.regex.Pattern;

import static com.programmers.java.application.config.Constant.*;

public class TokenValidator implements Validator {

    @Override
    public void validEmptyExpression(String expression) throws EmptyExpressionException {
        if (expression.length() == 0) {
            throw new EmptyExpressionException();
        }
    }

    @Override
    public void validateOnlyNumber(String expression) throws OnlyNumberException {
        if (Pattern.matches(NUMBER_REGEX, expression)) {
            throw new OnlyNumberException();
        }
    }

    @Override
    public void validZeroDivisionExpression(String expression) {
        if (Pattern.matches(ZERO_DIVIDE_REGEX, expression)) {
            throw new ZeroDivisionException();
        }
    }

    @Override
    public void validWrongOrderOperator(String expression) throws WrongUsedOperatorException {
        if (Pattern.matches(ADD_MINUS_NEXT_MULTIPLY_DIVIDE_OPERATOR_REGEX, expression)) {
            throw new WrongUsedOperatorException();
        }
    }

    @Override
    public void validateNumberOperator(String[] tokens) {
        for (String token : tokens) {
            if (!Pattern.matches(NUMBER_OPERATOR_REGEX, token)) {
                throw new UnsupportedNumberOperatorException();
            }
        }
    }

    @Override
    public void validateOutBoundNumber(String[] tokens) {
        for (String token : tokens) {
            if (!Pattern.matches(AVAILABLE_VALUE_REGEX, token)) {
                throw new OutboundMaxValueException();
            }
        }
    }

    @Override
    public void validateExpression(String expression) throws Exception {
        // validate: 식을 입력하지 않았을 경우
        validEmptyExpression(expression);

        // validate: 숫자만 입력할 경우
        validateOnlyNumber(expression);

        // validate: 0으로 나눈 경우
        validZeroDivisionExpression(expression);

        // validate: 연산자 순서를 잘못 입력했을 경우 (-,+ 다음 /, *)
        validWrongOrderOperator(expression);
    }

    @Override
    public void validateTokens(String[] tokens) {
        // validate: 숫자와 연산자 이외에 문자가 있는 경우
        validateNumberOperator(tokens);

        // validate: 최대 크기 보다 큰 경우
        validateOutBoundNumber(tokens);
    }
}
