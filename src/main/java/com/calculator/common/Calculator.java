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

    private int result;

    private Input input;
    private Output output;
    private Repository repository;

    @Override
    public void run() {
        while (true) {
            try {
                int inputType = this.input.inputType();

                if (inputType == 1) {
                    getMap();
                } else if (inputType == 2) {
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

    public int calculate(String input) {
        int result = 0;

        String after = change(input);

        // 후위 표기법 계산


        save(input, result);

        return result;
    }

    public String change(String input) {
        // 중위표기법 -> 후위표기법 변환
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

    private void save(String infix, int result) {
        Expression expression = new Expression(infix, result);
        repository.save(expression);
    }
}
