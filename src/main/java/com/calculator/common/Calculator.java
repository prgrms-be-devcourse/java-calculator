package com.calculator.common;

import com.calculator.entity.Expression;
import com.calculator.io.Input;
import com.calculator.io.Output;
import com.calculator.repository.Repository;
import lombok.Builder;

import java.io.IOException;
import java.util.Stack;

@Builder
public class Calculator implements Runnable {

    private double result;

    private Input input;
    private Output output;
    private Repository repository;

    @Override
    public void run() {
        while (true) {
            try {
                int inputType = this.input.inputType();

                if (inputType == EType.FIND.ordinal() + 1) {
                    getMap();
                } else if (inputType == EType.CAL.ordinal() + 1) {
                    this.result = calculate(this.input.inputNum());
                    output.output(result);
                } else {
                    return;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getMap() {
        repository.findAll();
    }

    public double calculate(String input) {
        double result = 0;

        Expression findExpression = repository.findByInfix(input);
        if (findExpression != null) {
            // 이미 존재하는 계산식의 경우 계산은 건너뛰고 map에서 객체 꺼내서 내역에만 한번더 저장처리
            result = findExpression.getResult();

            repository.save(findExpression);
            return result;
        }

        String after = change(input);

        // 후위표기법 계산
        Stack<Double> stack = new Stack<>();
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

        result = stack.pop();

        // 계산 완료 후 map에 저장
        Expression expression = new Expression(input, result);
        repository.save(expression);

        return result;
    }

    /**
     * 중위표기법 -> 후위표기법 변환
     */
    public String change(String input) {
        input = input.replaceAll("\\s", "");

        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                sb.append(chars[i]);
                continue;
            }

            if (chars[i] == EOperator.LEFT.getName()) {
                stack.push(chars[i]);
                continue;
            }

            if (chars[i] == EOperator.RIGHT.getName()) {
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

                int compare = findEnumByName(chars[i]).compare(findEnumByName(stack.peek()));
                if (compare < 0) {
                    break;
                }

                sb.append(stack.pop());

            }
            stack.push(chars[i]);
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
