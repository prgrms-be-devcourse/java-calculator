package com.programmers.java.application.config;

import com.programmers.java.application.exception.EmptyExpressionException;
import com.programmers.java.application.exception.OnlyNumberException;
import com.programmers.java.application.exception.WrongUsedOperatorException;

public interface Validator {
    void validEmptyExpression(String expression) throws EmptyExpressionException;

    void validateOnlyNumber(String expression) throws OnlyNumberException;

    void validZeroDivisionExpression(String expression);

    void validWrongOrderOperator(String expression) throws WrongUsedOperatorException;

    void validateNumberOperator(String[] tokens);

    void validateOutBoundNumber(String[] tokens);
}
