package org.programmers.calculator;

import java.util.*;

public class ExpressionEvaluator {
    private final String numberMatch = "[0-9]+";
    private final String operatorMatch = "[*+/-]";
    private final Map<String, Integer> operatorPriority = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public String requestCalculate(String inputFormula) {
        String[] formulaList = inputFormula.split(" ");
        List<String> postfixOperator = convertToPostfix(formulaList);
        String result = calculatePostfix(postfixOperator);
        return result;
    }

    public List<String> convertToPostfix(String[] formulaList) {
        List<String> postfixOperator = new ArrayList<>();
        Deque<String> operatorDeque = new ArrayDeque<>();

        for (String item : formulaList) {
            if (item.matches(numberMatch)) {
                postfixOperator.add(item);
            }
            if (item.matches(operatorMatch)) {
                if (operatorDeque.size() == 0) operatorDeque.add(item);
                else {
                    while (operatorDeque.size() > 0) {
                        if (operatorPriority.get(operatorDeque.peekLast()) <= operatorPriority.get(item)) {
                            operatorDeque.add(item);
                            break;
                        } else postfixOperator.add(operatorDeque.removeLast());
                    }
                    if (operatorDeque.size() == 0) operatorDeque.add(item);
                }
            }
        }

        while (operatorDeque.size() > 0) {
            postfixOperator.add(operatorDeque.removeLast());
        }


        return postfixOperator;
    }

    public boolean hasHigherPriority(String operator1, String operator2) {
        return operatorPriority.get(operator1) >= operatorPriority.get(operator2);
    }

    public String calculatePostfix(List<String> postfixOperator) {
        Deque<String> numberStack = new ArrayDeque<>();

        for (String item : postfixOperator) {
            if (item.matches(numberMatch)) {
                numberStack.add(item);
            } else if (item.matches(operatorMatch)) {
                int num2 = Integer.parseInt(numberStack.removeLast());
                int num1 = Integer.parseInt(numberStack.removeLast());

                switch (item) {
                    case "+":
                        numberStack.add(String.valueOf(Operator.add(num1, num2)));
                        break;
                    case "-":
                        numberStack.add(String.valueOf(Operator.subtract(num1, num2)));
                        break;
                    case "*":
                        numberStack.add(String.valueOf(Operator.multiply(num1, num2)));
                        break;
                    case "/":
                        numberStack.add(String.valueOf(Operator.divide(num1, num2)));
                        break;
                }
            }
        }

        return numberStack.removeLast();
    }
}