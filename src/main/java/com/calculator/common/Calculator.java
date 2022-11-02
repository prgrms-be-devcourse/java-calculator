package com.calculator.common;

import com.calculator.entity.Expression;
import com.calculator.repository.Repository;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

import static com.calculator.common.ExceptionStatus.DIVIDE_ZERO_ERROR;

public class Calculator {

    private final Repository repository;

    public Calculator(Repository repository) {
        this.repository = repository;
    }

    public String calculate(String input) {
        String calculatedValue = "";

        Optional<Expression> findExpression = repository.findByInfix(input);
        if (findExpression.isPresent()) {
            // 이미 존재하는 계산식의 경우 계산은 건너뛰고 map에서 객체 꺼내서 내역에만 한번더 저장처리
            calculatedValue = findExpression.get().getResult();

            repository.save(findExpression.get());
            return calculatedValue;
        }

        calculatedValue = calculatePostfix(input);
        return calculatedValue;
    }

    private String calculatePostfix(String input) {
        // 후위표기법 계산
        String calculatedValue = "";
        String after = changePostfix(input);

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

        return calculatedValue;
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
