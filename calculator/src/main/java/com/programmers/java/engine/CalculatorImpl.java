package com.programmers.java.engine;

import com.programmers.java.application.Console;
import com.programmers.java.application.Operator;
import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.model.History;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.regex.Pattern;

import static com.programmers.java.application.config.Constant.*;

public class CalculatorImpl implements Calculator {

    private Operator operator;
    private Console console;

    public CalculatorImpl(Operator operator, Console console) {
        this.operator = operator;
        this.console = console;
    }

    @Override
    public void run() {
        History history = new History();

        // Loop
        while (true) {
            // input option
            String inputOption = this.console.input("1. 조회\n2. 계산\n\n선택 : ");

            // check validate
            Optional<Integer> option = parseOption(inputOption);
            // incorrect -> continue
            if (option.isEmpty()) {
                console.inputError();
                continue;
            }

            // Option 1. Show history
            if (option.get().equals(1)) {
                String inputHistory = console.readHistory(history);

                console.printHistory(inputHistory);
            }

            // Option 2. Use calculator
            if (option.get().equals(2)) {
                String inputExpression = this.console.input("\n");
                Optional<Expression> expression = parseExpression(inputExpression);

                if (expression.isEmpty()) {
                    console.inputError();
                    continue;
                }

                // 계산
                Double answer = calculate(expression.get());
                console.printAnswer(answer);

                // 계산 저장
                history.addEquation(inputExpression, answer);
            }

        }
    }

    @Override
    public Double calculate(Expression expression) {

        // 후위연산으로 식 변경
        String[] postTokens = makePostfix(expression.getTokens());

        // 식 계산
        Double result = getResult(postTokens);

        return result;
    }

    @Override
    public Double getResult(String[] postTokens) {
        Stack<Double> stack = new Stack<>();
        Double lhs = 0.0;
        Double rhs = 0.0;

        for (String token : postTokens) {
            if (Pattern.matches(NUMBER_REGEX, token)) {
                stack.push(Double.parseDouble(token));
            } else if (Pattern.matches(ALL_OPERATOR_REGEX, token)) {
                rhs = stack.pop();
                lhs = stack.pop();

                if (token.equals("+")) {
                    stack.push(operator.plus(lhs, rhs));
                } else if (token.equals("-")) {
                    stack.push(operator.minus(lhs, rhs));
                } else if (token.equals("*")) {
                    stack.push(operator.multiply(lhs, rhs));
                } else if (token.equals("/")) {
                    stack.push(operator.divide(lhs, rhs));
                }
            }
        }

        return stack.peek();
    }

    @Override
    public String[] makePostfix(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String[] postTokens = new String[tokens.length];
        int index = 0;

        for (String token : tokens) {
            if (Pattern.matches(ALL_OPERATOR_REGEX, token)) {
                while (!stack.isEmpty() && (getRank(token) <= (getRank(stack.peek())))) {
                    postTokens[index++] = stack.pop();
                }
                stack.push(token);
            } else if (Pattern.matches(NUMBER_REGEX, token)) {
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
        if (Pattern.matches(ADD_MINUS_OPERATOR_REGEX, token)) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public Optional<Expression> parseExpression(String inputExpression) {

        // 숫자와 연산자 추출
        String[] tokens = inputExpression.split(" ");

        // validate: 잘못된 연산자나 숫자인지 체크
        for (String token : tokens) {
            if (!Pattern.matches(ALL_OPERATOR_REGEX, token) && !Pattern.matches(NUMBER_REGEX, token)) {
                return Optional.empty();
            }
        }

        return Optional.of(
                new Expression(
                     tokens
                )
        );
    }

    @Override
    public Optional<Integer> parseOption(String inputOption) {
        Integer result = 0;

        // validate: 숫자형인지 체크
        try {
            result = Integer.parseInt(inputOption);
        } catch (NumberFormatException exception) {
            return Optional.empty();
        }

        // validate: 1이나 2인지 체크
        if (result == 1 || result == 2) {
            return Optional.of(result);
        }
        return Optional.empty();
    }
}
