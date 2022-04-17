package calculator.engine.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostfixConverter {
    private Deque<String> stack = new ArrayDeque<>();
    private List<String> result = new ArrayList<>();

    // infix -> postfix 로 변환
    public List<String> convertToPostfix(String[] infix) {

        for (int i = 0; i < infix.length; i++) {
            String token = infix[i];

            // 피연산자인 경우
            if (isOperand(token)) {
                result.add(token);
            }

            // '('나 ')'인 경우
            else if (isBracket(token)) {
                handleBracket(token);
            }

            else {
                handleOperator(token);
            }
        }

        // stack에서 값 꺼내기
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // 괄호인지 아닌지 확인
    private boolean isBracket(String s) {
        if (s.equals("(") || s.equals(")"))
            return true;
        return false;
    }

    // 피연산자인지 아닌지 확인
    private boolean isOperand(String token) {
        return !Operator.isOperator(token) && !isBracket(token);
    }

    // 괄호 처리
    private void handleBracket(String token) {
        if (token.equals("(")) {
            stack.push(token);
        }

        // ')'인 경우
        else {
            while (!stack.isEmpty() && !stack.peek().equals("(")) {
                result.add(stack.pop());
            }
            stack.pop();
        }
    }

    // 연산자인 경우 처리
    private void handleOperator(String token) {
        while (!stack.isEmpty() &&
                !Operator.getOperator(stack.peek()).isEmpty() &&
                Operator.getOperator(token).get().comparePriority(Operator.getOperator(stack.peek())) <= 0) {
            result.add(stack.pop());
        }
        stack.push(token);
    }

}
