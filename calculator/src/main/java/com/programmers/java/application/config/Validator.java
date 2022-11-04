package com.programmers.java.application.config;

import com.programmers.java.application.exception.EmptyExpressionException;
import com.programmers.java.application.exception.OnlyNumberException;
import com.programmers.java.application.exception.WrongUsedOperatorException;

import java.util.List;

public interface Validator {
    void validEmptyExpression(String expression) throws EmptyExpressionException;

    void validateOnlyNumber(String expression) throws OnlyNumberException;

    void validZeroDivisionExpression(String expression);

    void validWrongOrderOperator(String expression) throws WrongUsedOperatorException;

    void validateNumberOperator(List<String> tokens);

    void validateOutBoundNumber(List<String> tokens);

    void validateExpression(String expression) throws Exception;

    void validateTokens(List<String> tokens);
}
