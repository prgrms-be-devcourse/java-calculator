package com.programmers.domain;

import com.programmers.util.Arithmetic;

public class ExpressionValidator {

    public void validate(String[] expression) {
        boolean isNumberTurn = true;
        for (String expr : expression) {
            if(Arithmetic.isNumber(expr) && isNumberTurn) {
                isNumberTurn = false;
            } else if(Arithmetic.isOperator(expr) && !isNumberTurn) {
                isNumberTurn = true;
            } else {
                throw new UnsupportedOperationException("올바른 계산식을 입력해주세요.");
            }
        }

        //계산식의 마지막이 숫자로 끝나지 않았다면
        if(isNumberTurn) {
            throw new UnsupportedOperationException("올바른 계산식을 입력해주세요.");
        }
    }
}
