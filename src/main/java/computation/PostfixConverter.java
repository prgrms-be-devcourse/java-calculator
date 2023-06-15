package computation;

import validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PostfixConverter implements Converter {
    private final StringBuilder sb = new StringBuilder();
    private final Map<String, Integer> priority = Map.of(
            "(", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    private boolean checkHigherPriority(Stack<String> operatorStack, String item) {
        return priority.get(operatorStack.peek()) >= priority.get(item);
    }

    public void addElement(List<String> list) {
        if (sb.length() > 0) {
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    @Override
    public List<String> convert(String expression) {
        List<String> postfix = new ArrayList<>();

        Stack<String> operatorStack = new Stack<>();
        String[] infixArray = expression.split("");
        sb.setLength(0);

        for (int i = 0; i < infixArray.length; i++) {
            // 숫자라면 단순히 추가
            if (Validator.isNumber(infixArray[i])) {
                sb.append(infixArray[i]);

                if (i == infixArray.length - 1) {
                    postfix.add(sb.toString());
                }
            } else {
                addElement(postfix);

                if (Validator.isOperator(infixArray[i])) {
                    // 연산자라면 먼저 우선순위 계산
                    if (!operatorStack.isEmpty()) {
                        while (!operatorStack.isEmpty() && checkHigherPriority(operatorStack, infixArray[i])) {
                            postfix.add(operatorStack.pop());
                        }
                    }
                    operatorStack.push(infixArray[i]);
                } else if (Validator.isOpenBrackets(infixArray[i])) {
                    operatorStack.push(infixArray[i]);
                } else if (Validator.isCloseBrackets(infixArray[i])) {
                    // 괄호에 대한 처리
                    while (!operatorStack.isEmpty()) {
                        String poppedItem = operatorStack.pop();
                        if (Validator.isOpenBrackets(poppedItem)) break;
                        postfix.add(poppedItem);
                    }
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.add(operatorStack.pop());
        }
        return postfix;
    }
}
