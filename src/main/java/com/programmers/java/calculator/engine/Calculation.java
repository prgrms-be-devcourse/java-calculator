package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.exception.CalculatorException;
import com.programmers.java.calculator.engine.exception.InputException;
import com.programmers.java.calculator.engine.model.Infix;
import com.programmers.java.calculator.engine.model.Postfix;

import java.util.*;
import java.util.regex.Pattern;

public class Calculation {
    private final PostfixConverter postfixConverter = new PostfixConverter();

    public Integer calculate(String inputString) {
        inputString = inputString.replace(" ", "");
        Boolean pass = validateInput(inputString);
        if (!pass) {
            throw new InputException("계산식이 잘못되었습니다.");
        }
        Infix infix = parse(inputString);
        Postfix postfix = postfixConverter.convertInfixToPostfix(infix);
        return solvePostfix(postfix);
        //TODO : inputString 과 result 를 이용해 조회 기능에 사용될 History 객체 생성하기
    }

    private Boolean validateInput(String inputString) {
        return Pattern.matches("[\\d]+([+\\-*/][\\d]+)*", inputString);
    }

    private Integer solvePostfix(Postfix postfix) {
        Stack<Integer> numberStore = new Stack<>();
        postfix.forEach((s) -> {
            if(Pattern.matches("[\\d]+", s)) {
                int num = Integer.parseInt(s);
                numberStore.add(num);
            } else if(numberStore.size() < 2) {
                throw new CalculatorException("잘못된 계산식을 잡아내지 못했습니다.");
            }
            else {
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
                    default:
                        throw new CalculatorException("잘못된 계산식을 잡아내지 못했습니다.");
                }
            }
        });
        if (numberStore.size() > 1) throw new CalculatorException("잘못된 계산식을 잡아내지 못했습니다.");
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
        if (num1.equals(0)) {
            throw new InputException("0으로 나눌 수는 없습니다.");
        }
        return num2 / num1;
    }

    private Infix parse(String inputString) {
        StringTokenizer tokens = new StringTokenizer(inputString, "+\\-*/", true);
        List<String> tokenList = new ArrayList<>();
        while (tokens.hasMoreTokens()) {
            tokenList.add(tokens.nextToken());
        }
        return new Infix(tokenList);
    }
}
