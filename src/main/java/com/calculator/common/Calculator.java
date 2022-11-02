package com.calculator.common;

import com.calculator.entity.Expression;
import com.calculator.io.Input;
import com.calculator.io.Output;
import com.calculator.repository.Repository;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.calculator.common.ExceptionStatus.DIVIDE_ZERO_ERROR;

public class Calculator {
    private final Input input;
    private final Output output;
    private final Repository repository;

    private boolean isExited = false;

    public Calculator(Input input, Output output, Repository repository) {
        this.input = input;
        this.output = output;
        this.repository = repository;
    }

    public void run() {
        String result = "";
        while (!isExited) {
            try {
                String inputType = input.inputType();
                MenuType menuType = MenuType.of(inputType);

                switch (menuType) {
                    case FIND:
                        getMap();
                        break;
                    case CAL:
                        String inputString = input.inputNum();
                        result = calculate(inputString);
                        output.outputDisplay(result);
                        break;
                    case END:
                        isExited = true;
                        break;
                }
            } catch (BusinessException businessException) {
                output.outputDisplay(businessException.getMessage());
            }
        }
    }

    public void getMap() {
        repository.findAll();
    }

    public String calculate(String input) {
        String calculatedValue = "";

        Expression findExpression = repository.findByInfix(input);
        if (findExpression != null) {
            // 이미 존재하는 계산식의 경우 계산은 건너뛰고 map에서 객체 꺼내서 내역에만 한번더 저장처리
            calculatedValue = findExpression.getResult();

            repository.save(findExpression);
            return calculatedValue;
        }

        String after = changePostfix(input);

        // 후위표기법 계산
        Deque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < after.length(); i++) {
            if (Character.isDigit(after.charAt(i))) {
                stack.push((double) after.charAt(i) - '0');
            } else {
                Double b = stack.pop();
                Double a = stack.pop();

                Operator operator = Operator.of(after.charAt(i));
                Double calculate = operator.calculate(a, b);

                if (Double.isInfinite(calculate)) {
                    throw new BusinessException(DIVIDE_ZERO_ERROR);
                }

                stack.push(calculate);
            }
        }

        calculatedValue = String.valueOf(stack.pop());

        // 계산 완료 후 map에 저장
        Expression expression = new Expression(input, calculatedValue);
        repository.save(expression);

        return expression.getResult();
    }

    /**
     * 중위표기법 -> 후위표기법 변환
     */
    public String changePostfix(String input) {
        input = input.replaceAll("\\s", "");

        Deque<Character> postfixDeque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char chars: input.toCharArray()) {
            if (Character.isDigit(chars)) {
                sb.append(chars);
                continue;
            }

            if (chars == '(') {
                postfixDeque.push(chars);
                continue;
            }

            if (chars == ')') {
                while (true) {
                    Character pop = postfixDeque.pop();

                    if (pop.equals('(')) {
                        break;
                    }
                    sb.append(pop);
                }
                continue;
            }

            while (!postfixDeque.isEmpty()) {
                // peek()의 우선순위보다 현재 연산자의 우선순위가 높아질 때까지 진행
                if (postfixDeque.peek().equals('(')) {
                    break;
                }

                int compare = Operator.of(chars).compare(Operator.of(postfixDeque.peek()));
                if (compare < 0) {
                    break;
                }

                sb.append(postfixDeque.pop());
            }
            postfixDeque.push(chars);
        }

        while (!postfixDeque.isEmpty()) {
            sb.append(postfixDeque.pop());
        }

        return sb.toString();
    }
}
