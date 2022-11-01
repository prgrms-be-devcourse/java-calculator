package com.calculator.common;

import com.calculator.entity.Expression;
import com.calculator.io.Input;
import com.calculator.io.Output;
import com.calculator.repository.Repository;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private double result;

    private final Input input;
    private final Output output;
    private final Repository repository;

    private final ValidatorHandler validator;

    public Calculator(Input input, Output output, Repository repository, ValidatorHandler validator) {
        this.input = input;
        this.output = output;
        this.repository = repository;
        this.validator = validator;
    }

    public void run() throws BaseException, IOException {
        while (true) {
            try {
                int inputType = validator.typeError(input.inputType());

                if (inputType == EType.FIND.getNum()) {
                    getMap();
                } else if (inputType == EType.CAL.getNum()) {
                    result = calculate(input.inputNum());
                    output.output(result);
                } else {
                    return;
                }

            } catch (Exception e) {
                throw e;
            }
        }
    }

    public void getMap() {
        repository.findAll();
    }

    public double calculate(String input) throws BaseException {
        try {
            double calculatedValue = 0;

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

                    EOperator eOperator = findEnumByName(after.charAt(i));
                    stack.push(eOperator.calculate(a, b));
                }
            }

            calculatedValue = stack.pop();

            // 계산 완료 후 map에 저장
            Expression expression = new Expression(input, calculatedValue);
            repository.save(expression);

            return calculatedValue;
        } catch (BaseException e) {
            throw e;
        }
    }

    /**
     * 중위표기법 -> 후위표기법 변환
     */
    public String changePostfix(String input) {
        input = input.replaceAll("\\s", "");

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char chars: input.toCharArray()) {
            if (Character.isDigit(chars)) {
                sb.append(chars);
                continue;
            }

            if (chars == EOperator.LEFT.getName()) {
                stack.push(chars);
                continue;
            }

            if (chars == EOperator.RIGHT.getName()) {
                while (true) {
                    Character pop = stack.pop();

                    if (pop.equals(EOperator.LEFT.getName())) {
                        break;
                    }
                    sb.append(pop);
                }
                continue;
            }

            while (!stack.isEmpty()) {
                // peek()의 우선순위보다 현재 연산자의 우선순위가 높아질 때까지 진행
                if (stack.peek().equals(EOperator.LEFT.getName())) {
                    break;
                }

                int compare = findEnumByName(chars).compare(findEnumByName(stack.peek()));
                if (compare < 0) {
                    break;
                }

                sb.append(stack.pop());

            }
            stack.push(chars);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public EOperator findEnumByName(char name) {
        EOperator[] values = EOperator.values();

        for (EOperator e : values) {
            if (e.getName() == name) {
                return e;
            }
        }

        return null;
    }
}
