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
    public void validWrongOrderOperator(String expression) throws WrongOrderOperatorException {
        if (Pattern.matches(ADD_MINUS_NEXT_MULTIPLY_DIVIDE_OPERATOR_REGEX, expression)) {
            throw new WrongOrderOperatorException();
        }
    }

    @Override
    public void validMultiplyDivideDouble(String expression) throws DoubleMultiplyDivideException {
        if (Pattern.matches(DOUBLE_MULTIPLY_DIVIDE_OPERATOR_REGEX, expression)) {
            throw new DoubleMultiplyDivideException();
        }
    }

    @Override
    public void validateNumberOperator(String[] tokens) {
        for (String token : tokens) {
            if (!Pattern.matches(NUMBER_OPERATOR_REGEX, token)) {
                throw new NonNumberOperatorException();
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
}
