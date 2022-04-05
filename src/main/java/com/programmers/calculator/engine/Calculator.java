package com.programmers.calculator.engine;

import com.programmers.calculator.engine.exception.Validator;
import com.programmers.calculator.engine.repository.Repository;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator {
    private final Repository repository = new Repository(); // 연산식, 결과 저장

    // 연산식을 후위표기법으로 변환 -> Optional null체크 -> 후위표기법 계산하고 출력 -> map에 연산식, 결과 저장
    public Optional<Integer> calculate(String expression) {
        Optional<List<String>> postfix = infixToPostfix(expression);

        // 예외 출력
        if(!postfix.isPresent()) {
            return Optional.empty();
        }

        // 후위표기법 연산
        Stack<String> stack = new Stack<>();
        for(String s : postfix.get()) {
            if(Pattern.matches(Regex.NUM, s) && !s.equals("-")) {
                stack.push(s);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.push(s.equals("+") ? Integer.toString(num1 + num2) :
                           s.equals("-") ? Integer.toString(num1 - num2) :
                           s.equals("*") ? Integer.toString(num1 * num2) :
                                           Integer.toString(num1 / num2));
            }
        }

        int result = Integer.parseInt(stack.pop());
        repository.put(expression, result); // map에 저장
        return Optional.of(result);
    }

    // 예외 체크 후 중위표기법 => 후위표기법 변환 (수식이 잘못 입력된 경우 Optional.empty() 리턴)
    public Optional<List<String>> infixToPostfix(String infix) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String[] numsAndSymbols = Arrays.stream(infix.split(" ")) // " "로 split & 공백 제거
                .filter(s -> !s.equals(" "))
                .toArray(String[]::new);

        // 예외 체크
        if(!Validator.exceptionCheck(numsAndSymbols)) {
            return Optional.empty();
        }

        // 중위 표기법 => 후위표기법 변환
        for(String numAndSymbol : numsAndSymbols) {
            if (Pattern.matches(Regex.NUM, numAndSymbol) && !numAndSymbol.equals("-")) {
                postfix.add(numAndSymbol);
            } else if (numAndSymbol.equals("(")) {
                stack.push(numAndSymbol);
            } else if (Operator.isOperator(numAndSymbol)) {
                if (!stack.isEmpty() && Operator.getPriority(stack.peek()) >= Operator.getPriority(numAndSymbol)) {
                    postfix.add(stack.pop());
                    stack.push(numAndSymbol);
                } else {
                    stack.push(numAndSymbol);
                }
            } else if (numAndSymbol.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return Optional.of(postfix);
    }

    public Optional<List<String>> getData() {
        Map<String, Integer> map = repository.getRepository();
        if(map.isEmpty()) return Optional.empty();

        List<String> data = new ArrayList<>();

        for (String expression : map.keySet()) {
            int result = map.get(expression);
            data.add(expression + " = " + result);
        }

        return Optional.of(data);
    }
}
