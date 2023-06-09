package calculation;

import validation.Validator;
import java.util.*;

public class Calculator {
    private final String infixExpr;
    private String postfixExpr;
    private final Map<String, Integer> priority = new HashMap<>() {{
        put("(", 0);
        put("+", 1);
        put("-", 1);
        put("*", 2);
        put("/", 2);
    }};

    public Calculator(String infixExpr) {
        this.infixExpr = removeWhiteSpace(infixExpr);
        convertToPostfix();
    }

    public String removeWhiteSpace(String getExpr) {
        return getExpr.replace(" ", "");
    }

    public <T> boolean stackIsNotEmpty(Stack<T> getStack) {
        return !getStack.isEmpty();
    }

    public void convertToPostfix() {
        StringBuilder sb = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();
        String[] infixArray = infixExpr.split("");

        for (String item : infixArray) {
            // 숫자라면 단순히 추가
            if (Validator.isNumber(item)) {
                sb.append(item);
            } else if (Validator.isOperator(item)) {
                // 연산자라면 먼저 우선순위 계산
                if (operatorStack.isEmpty()) {
                    operatorStack.push(item);
                } else {
                    // 우선 순위가 더 높은 연산자 모두 꺼내기
                    while (stackIsNotEmpty(operatorStack) && (priority.get(operatorStack.peek()) >= priority.get(item))) {
                        sb.append(operatorStack.pop());
                    }
                    operatorStack.push(item);
                }
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

        postfixExpr = sb.toString();
        System.out.println(postfixExpr);
    }

    public int calculate() {
        Stack<Integer> calculationStack = new Stack<>();
        String[] postfixArray = postfixExpr.split("");

        for (String item : postfixArray) {
            if (Validator.isNumber(item)) {
                calculationStack.push(Integer.parseInt(item));
            } else if (Validator.isOperator(item)) {
                Integer operand2 = calculationStack.pop();
                Integer operand1 = calculationStack.pop();

                switch (item) {
                    case "+":
                        calculationStack.push(operand1 + operand2);
                        break;
                    case "-":
                        calculationStack.push(operand1 - operand2);
                        break;
                    case "*":
                        calculationStack.push(operand1 * operand2);
                        break;
                    case "/":
                        calculationStack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return calculationStack.pop();
    }
}
