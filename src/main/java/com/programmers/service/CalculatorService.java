package com.programmers.service;

import com.programmers.util.CalculatorHelper;
import com.programmers.util.Converter;

public class CalculatorService {

    //계산 수행
    public int calculate(String expression) {
        //계산
        String postfixExpression = Converter.convertToPostFix(expression);
        int result = CalculatorHelper.calculateExpression(postfixExpression);

        //저장
        return result;
    }

    //history 조회
}
