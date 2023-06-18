package calculator.engine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class InitCalculator {
    public static List<String> calculate(String infixCalculator) {
            Stack<String> stack = new Stack<>();
            List<String> postfixExpression = new ArrayList<>();

            for (String ch : infixCalculator.split(" ")) {
                if(Pattern.matches("[0-9]+",ch)){
                    postfixExpression.add(ch);
                } else if (ch.equals("(")) {
                    stack.push(ch);
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfixExpression.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                        postfixExpression.add(stack.pop());
                    }
                    stack.push(ch);
                }
            }
            while (!stack.isEmpty()) {
                postfixExpression.add(stack.pop());
            }
            return postfixExpression;
        }
    private static int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}
