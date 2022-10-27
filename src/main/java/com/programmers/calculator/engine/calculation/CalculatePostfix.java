package com.programmers.calculator.engine.calculation;

import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

public class CalculatePostfix implements Calculate {
    private final String NUMBER = "^[0-9]*$";
    static Stack<Double> stack = new Stack<>();


    @Override
    public Double calculate(List<String> postfix) {
        for (String token : postfix) {
            isNumber(token);
        }
        return stack.pop();
    }


    //이렇게 세세하게 나누는 방법이 좋은건지 궁금합니다.
    void isNumber(String token) {
        if (token.matches(NUMBER)) {
            pushStack(token);
        } else {
            calculateStack(token);
        }
    }

    void pushStack(String token) {
        stack.push(Double.valueOf(token));
    }

    void calculateStack(String token) {
        double number1, number2;
        number2 = stack.pop();
        number1 = stack.pop();
        stack.push(Symbol.calculate(token, number1, number2));
    }


}
