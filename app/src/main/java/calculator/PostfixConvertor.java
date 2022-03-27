package calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PostfixConvertor {
    private static Deque<String> stack = new ArrayDeque<>();
    public static String[] convert(String[] infix) {
        if(infix == null || infix.length == 0) throw new IllegalArgumentException();
        String[] postfix = new String[infix.length];
        int indexIndicator = 0;
        for (int i = 0; i < infix.length; i++) {
            String element = infix[i];
            if (i % 2 == 0) {
                postfix[indexIndicator++] = element;
                continue;
            }
            while(OPERATOR.getPriority(stack.peek()) >= OPERATOR.getPriority(element)) {
                postfix[indexIndicator++] = stack.pop();
            }
            stack.push(element);
        }
        while(!stack.isEmpty()) {
            postfix[indexIndicator++] = stack.pop();
        }
        return postfix;
    }
}
