package calculation;

import validation.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PostfixConverter implements Converter {
    private final String infixExpr;
    private final Map<String, Integer> priority = new HashMap<>() {{
        put("(", 0);
        put("+", 1);
        put("-", 1);
        put("*", 2);
        put("/", 2);
    }};

    public PostfixConverter(String infixExpr) {
        this.infixExpr = infixExpr;
    }

    private <T> boolean stackIsNotEmpty(Stack<T> getStack) {
        return !getStack.isEmpty();
    }

    private boolean checkHigherPriority(Stack<String> operatorStack, String item) {
        return priority.get(operatorStack.peek()) >= priority.get(item);
    }

    @Override
    public String convert() {
        StringBuilder sb = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();
        String[] infixArray = infixExpr.split("");

        for (String item : infixArray) {
            // 숫자라면 단순히 추가
            if (Validator.isNumber(item)) {
                sb.append(item);
            } else if (Validator.isOperator(item)) {
                // 연산자라면 먼저 우선순위 계산
                if (stackIsNotEmpty(operatorStack)) {
                    while (stackIsNotEmpty(operatorStack) && checkHigherPriority(operatorStack, item)) {
                        sb.append(operatorStack.pop());
                    }
                }
                operatorStack.push(item);
            } else if (Validator.isOpenBrackets(item)) {
                operatorStack.push(item);
            } else if (Validator.isCloseBrackets(item)) {
                // 괄호에 대한 처리
                while (stackIsNotEmpty(operatorStack)) {
                    String poppedItem = operatorStack.pop();
                    if (Validator.isOpenBrackets(poppedItem)) break;
                    sb.append(poppedItem);
                }
            }
        }

        while (stackIsNotEmpty(operatorStack)) {
            sb.append(operatorStack.pop());
        }

        return sb.toString();
    }
}
