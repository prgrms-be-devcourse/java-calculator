package org.programmers.domain.expression;

import org.programmers.constant.Operator;

public class ExpressionValidator {

    public boolean isOperator(String symbol) {
        return Operator.find(symbol).isPresent();
    }

    public boolean isNumber(String number) {
        if (number.length() == 1) {
            return number.charAt(0) >= '0' && number.charAt(0) <= '9';
        }
        return false;
    }
}
