package com.programmers.java.calculator.utility;

import java.util.*;

public class ArithmeticPostfixConvertor implements PostfixConvertor {
    private static final Map<String, Integer> operatorPriority = new HashMap<String, Integer>() {{
        put("+", 0);
        put("-", 0);
        put("*", 1);
        put("/", 1);
    }};
    private static final List<String> operators = Arrays.asList("+", "-", "*", "/");
    private Stack<String> stack = new Stack<>();

    @Override
    public String setPostfix(String exp) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] expSplit = exp.split(" ");
        for (String s: expSplit){
            Optional<String> operator = operators.stream()
                    .filter(op -> op.equals(s))
                    .findAny();
            if (operator.isPresent()){
                if (!stack.isEmpty()) {
                    if (operatorPriority.get(stack.peek()) >= operatorPriority.get(operator.get())) {
                        stringBuilder.append(stack.pop());
                        stringBuilder.append(" ");
                    }
                }
                stack.push(operator.get());
            } else {
                stringBuilder.append(s);
                stringBuilder.append(" ");
            }
        }
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();
    }
}
