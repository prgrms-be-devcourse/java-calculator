package org.programmers.java.calculation;

import java.util.*;

public class Calculation {

    private final String numberMatch = "[0-9]+";
    private final String operatorMatch = "[*+/-]";
    private final Map<String, Integer> operatorPriority = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    // 연산 요청 후 연산 작업 로직
    public String requestCalculate(String inputFormula){
        String[] formulaList = inputFormula.split(" ");
        List<String> postfixOperator = infixToPostfix(formulaList);
        String result = postfixCalculate(postfixOperator);
        return result;
    }

    // 중위 -> 후위
    public List<String> infixToPostfix(String[] formulaList){

        List<String> postfixOperator = new ArrayList<>();
        Deque<String> operatorDeque = new ArrayDeque<>();

        for(String item : formulaList){
            if(item.matches(numberMatch)){
                postfixOperator.add(item);
            }
            if(item.matches(operatorMatch)){
                if(operatorDeque.size() == 0) {
                    operatorDeque.add(item);
                    continue;
                }
                if(operatorDeque.size() != 0){
                    while(operatorDeque.size() > 0){
                        if(operatorPriority.get(operatorDeque.peekLast()) <= operatorPriority.get(item)) {
                            operatorDeque.add(item);
                            break;
                        }
                        postfixOperator.add(operatorDeque.removeLast());
                    }
                    if(operatorDeque.size() == 0) {
                        operatorDeque.add(item);
                    }
                }
            }
        }

        while(operatorDeque.size() > 0){
            postfixOperator.add(operatorDeque.removeLast());
        }


        return postfixOperator;
    }


    // 후위 -> 연산
    public String postfixCalculate(List<String> postfixOperator){
        Deque<String> numberDeque = new ArrayDeque<>();
        for(String item : postfixOperator){
            if(item.matches(numberMatch)) {
                numberDeque.add(item);
            }
            if(item.matches(operatorMatch)){
                int num2 = Integer.parseInt(numberDeque.removeLast());
                int num1 = Integer.parseInt(numberDeque.removeLast());

                switch (item){
                    case "+":
                        numberDeque.add(String.valueOf(Operator.plus(num1, num2)));
                        break;
                    case "-":
                        numberDeque.add(String.valueOf(Operator.minus(num1, num2)));
                        break;
                    case "*":
                        numberDeque.add(String.valueOf(Operator.multiply(num1, num2)));
                        break;
                    case "/":
                        numberDeque.add(String.valueOf(Operator.divide(num1, num2)));
                        break;
                }
            }
        }
        return numberDeque.removeLast();
    }
}
