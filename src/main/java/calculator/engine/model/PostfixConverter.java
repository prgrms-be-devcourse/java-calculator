package calculator.engine.model;

import java.util.ArrayList;
import java.util.Stack;

public interface PostfixConverter {

    // infix -> postfix 로 변환
    static ArrayList<String> convertToPostfix(String[] infix) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < infix.length; i++) {
            String s = infix[i];

            // 피연산자인 경우
            if (!Operator.isOperator(s) && !isBracket(s)) {
                result.add(s);
            }

            // '('인 경우
            else if (s.equals("(")) {
                stack.push(s);
            }

            // ')'인 경우
            else if (s.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.add(stack.pop());
                }
                stack.pop();
            }
            
            else {
                while (!stack.isEmpty() &&
                        !Operator.getOperator(stack.peek()).isEmpty() &&
                        Operator.getOperator(s).get().comparePriority(Operator.getOperator(stack.peek())) <= 0) {
                    result.add(stack.pop());
                }
                stack.push(s);
            }
        }

        // stack에서 값 꺼내기
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // 괄호인지 아닌지 확인
    private static boolean isBracket(String s) {
        if (s.equals("(") || s.equals(")"))
            return true;
        return false;
    }

}
