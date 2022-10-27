package com.programmers.java.engine.calculator;

import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.util.Operator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PostfixCalculator implements Calculator<Integer> {
    @Override
    public Integer calculate(Expression expression) {
        Deque<Double> deque = new ArrayDeque<>();
        List<String> tokens = Arrays.asList(expression.toString().trim().split(" "));

        tokens.stream()
                .forEach(token -> {
                    // 피연산자(숫자)인 경우 스택에 바로 삽입
                    if (token.matches("[0-9]+")) {
                        deque.push(Double.parseDouble(token));
                    } else {
                        Operator operator = Operator.findOperator(token);

                        // 연산자인 경우 추출 -> 계산 -> 스택에 삽입 (연산 순서에 주의)
                        double y = deque.pollFirst();
                        double x = deque.pollFirst();
                        deque.addFirst((double) operator.calculate(x, y));
                    }
                });

        return deque.pop().intValue();
    }
}
