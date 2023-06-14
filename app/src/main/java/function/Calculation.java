package function;

import operator.Operator;

import java.util.Stack;

import static validator.Validator.checkPositiveNum;
import static validator.Validator.checkValidOperator;

public class Calculation {
    private static int priority(char operator) {
        if (operator == '(' || operator == ')') {
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

    public String convertPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String[] split = expression.split(" ");

        for (String now : split) {
            if (checkPositiveNum(now)) {
                sb.append(now).append(" ");
                continue;
            }

            char c = checkValidOperator(now.charAt(0));

            switch (c) {
                case '(':
                    stack.add(c);
                    break;

                case ')':
                    while (!stack.isEmpty() && !(stack.peek() == '(')) {
                        sb.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                    break;
                default:
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        sb.append(stack.pop()).append(" ");
                    }
                    stack.add(c);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString();
    }

    public double calculatePostfix(String postfix) {
        String[] pfs = postfix.split(" ");
        Stack<String> stack = new Stack<>();
        Operator operator = new Operator();

        for (String pf : pfs) {
            if (checkPositiveNum(pf)) {
                stack.add(pf);
                continue;
            }

            char op = pf.charAt(0);
            double numEnd = Double.parseDouble(stack.pop());
            double numFront = Double.parseDouble(stack.pop());

            String result = "";
            switch (op) {
                case '+':
                    result = String.valueOf(operator.add(numFront, numEnd));
                    break;
                case '-':
                    result = String.valueOf(operator.subtract(numFront, numEnd));
                    break;
                case '*':
                    result = String.valueOf(operator.multiply(numFront, numEnd));
                    break;
                case '/':
                    result = String.valueOf(operator.divide(numFront, numEnd));
                    break;
            }

            stack.add(result);
        }

        return Double.parseDouble(stack.pop());
    }
}
