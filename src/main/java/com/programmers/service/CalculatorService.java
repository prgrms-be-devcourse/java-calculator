package com.programmers.service;

import com.programmers.util.Converter;

public class CalculatorService {

    //계산 수행
    public int calculate(String expression){
        String postfixExpression = Converter.convertToPostFix(expression);

        return 0;
    }

    //history 조회
}
