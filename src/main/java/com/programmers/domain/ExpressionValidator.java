package com.programmers.domain;

import com.programmers.util.Arithmetic;

import java.util.List;

public class ExpressionValidator {
    public void validate(List<String> expression) {
        boolean isNumberTurn = true;
        for (String expr : expression) {
            if (Arithmetic.isNumber(expr) && isNumberTurn) {
                isNumberTurn = false;
            } else if (Arithmetic.isOperator(expr) && !isNumberTurn) {
                isNumberTurn = true;
            } else {
                throw new UnsupportedOperationException(Arithmetic.WRONG_EXPRESSION);
            }
        }

        if (isNumberTurn) {
            throw new UnsupportedOperationException(Arithmetic.WRONG_EXPRESSION);
        }
    }
}
