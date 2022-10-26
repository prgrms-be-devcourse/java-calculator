package org.example.compute;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ComputeArithmeticOperation implements Compute{
    private final String patternNumber = "\\d+";

    @Override
    public List<String> convertTokenToPostfix(List<String> tokens) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches(patternNumber)) {
                postfix.add(token);
            } else {
                while (!stack.isEmpty() && isLowerThanStack(token, stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }

    @Override
    public long calculate(List<String> postfix) {
        Stack<Long> stack = new Stack<>();
        for (String token : postfix) {
            if (token.matches(patternNumber)) {
                stack.push(Long.parseLong(token));
            } else {
                long firstNumber = stack.pop();
                long secondNumber = stack.pop();
                Operator operator = Operator.getOperator(token);

                stack.push(operator.calculate(secondNumber, firstNumber));
            }
        }
        return stack.pop();
    }

    @Override
    public long compute(String input) {
        // 입력값을 빈칸을 기준으로 token 화
        List<String> token = convertToToken(input);
        // token 을 postfix 로 변환
        List<String> postfix = convertTokenToPostfix(token);
        // 계산
        long result = calculate(postfix);
        return result;
    }

    private boolean isLowerThanStack(String newOne, String peekOne) {
        Operator newOperator = Operator.getOperator(newOne);
        Operator peekOperator = Operator.getOperator(peekOne);
        return peekOperator.getPriority() >= newOperator.getPriority();
    }

}
