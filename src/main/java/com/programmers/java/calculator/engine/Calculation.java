package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Infix;
import com.programmers.java.calculator.engine.model.Postfix;

import java.util.Optional;
import java.util.Stack;

public class Calculation {
    private final PostfixConverter postfixConverter = new PostfixConverter();

    public Optional<Integer> calculate(String inputString) {
        Boolean pass = validateInput(inputString);
        if (!pass) {
            return Optional.empty();
        }
        Infix infix = parse(inputString);
        Postfix postfix = postfixConverter.convertInfixToPostfix(infix);
        Integer result = solvePostfix(postfix);
        return Optional.of(result);
        //TODO : inputString과 result를 이용해 조회 기능에 사용될 History 객체 생성하기
    }

    private Boolean validateInput(String inputString) {
        //TODO : inputString에 대해 유효한 형식인지 검증을 해야함.
        return true;
    }

    private Integer solvePostfix(Postfix postfix) {
        Stack<Integer> numberStore = new Stack<>();
        postfix.forEach((s) -> {
            try {
                Integer num = Integer.parseInt(s);
                numberStore.add(num);
            } catch(NumberFormatException e) {
                switch (s) {
                    case "+":
                        numberStore.add(sum(numberStore.pop(), numberStore.pop()));
                        break;
                    case "-":
                        numberStore.add(sub(numberStore.pop(), numberStore.pop()));
                        break;
                    case "*":
                        numberStore.add(mul(numberStore.pop(), numberStore.pop()));
                        break;
                    case "/":
                        numberStore.add(div(numberStore.pop(), numberStore.pop()));
                        break;
                }
            }
        });
        return numberStore.pop();
    }

    private int sum(Integer num1, Integer num2) {
        return num2 + num1;
    }

    private int sub(Integer num1, Integer num2) {
        return num2 - num1;
    }

    private int mul(Integer num1, Integer num2) {
        return num2 * num1;
    }

    private int div(Integer num1, Integer num2) {
        return num2 / num1;
    }

    private Infix parse(String inputString) {
        String[] strArr = inputString.split("\\s+");
        return new Infix(strArr);
    }
}
