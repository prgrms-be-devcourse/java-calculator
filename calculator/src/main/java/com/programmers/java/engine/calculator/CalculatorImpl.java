package com.programmers.java.engine.calculator;

import com.programmers.java.application.Operator;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import lombok.AllArgsConstructor;

import java.util.Stack;
import java.util.regex.Pattern;

import static com.programmers.java.application.config.Constant.*;

@AllArgsConstructor
public class CalculatorImpl implements Calculator {

    @Override
    public Answer calculate(Expression expression) {

        // 후위연산으로 식 변경
        String[] postTokens = makePostfix(expression.getTokens());

        // 식 계산
        Answer result = getResult(postTokens);

        return result;
    }

    @Override
    public Answer getResult(String[] postTokens) {
        Stack<Double> stack = new Stack<>();
        Double lhs = 0.0;
        Double rhs = 0.0;

        for (String token : postTokens) {
            if (isMatchRegex(token, NUMBER_REGEX)) {
                stack.push(Double.parseDouble(token));
            } else if (isMatchRegex(token, ALL_OPERATOR_REGEX)) {
                rhs = stack.pop();
                lhs = stack.pop();

                Answer answer = Operator.calculate(token, lhs, rhs);
                stack.push(answer.getValue());
            }
        }

        return Answer.builder()
                .value(stack.peek())
                .build();
    }

    private boolean isMatchRegex(String token, String regex) {
        return Pattern.matches(regex, token);
    }

    @Override
    public String[] makePostfix(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String[] postTokens = new String[tokens.length];
        int index = 0;

        for (String token : tokens) {
            if (isMatchRegex(token, ALL_OPERATOR_REGEX)) {
                while (!stack.isEmpty() && (getRank(token) <= (getRank(stack.peek())))) {
                    postTokens[index++] = stack.pop();
                }
                stack.push(token);
            } else if (isMatchRegex(token, NUMBER_REGEX)) {
                postTokens[index++] = token;
            }
        }

        while (!stack.isEmpty()) {
            postTokens[index++] = stack.pop();
        }

        return postTokens;
    }

    // 연산자 우선순위 파악, 숫자 높을 수록 우선순위 높음
    private Integer getRank(String token) {
        if (isMatchRegex(token, ADD_MINUS_OPERATOR_REGEX)) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public Expression parseExpression(String inputExpression) {

        // 숫자와 연산자 추출
        String[] tokens = inputExpression.split(" ");

        // validate: 잘못된 연산자나 숫자인지 체크
        for (String token : tokens) {
            if (!isMatchRegex(token, ALL_OPERATOR_REGEX) && !isMatchRegex(token, NUMBER_REGEX)) {

            }
        }

        return new Expression(tokens);
    }

}
