package hyuk.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    public int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    public int divide(int firstOperand, int secondOperand) {
        if (secondOperand == 0) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
        return firstOperand / secondOperand;
    }

    public int multiply(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    public Result calculate(PostOrderFormula postOrderFormula) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : postOrderFormula.getFormula()) {
            if (isOperand(token)) {
                stack.addLast(Integer.parseInt(token));
                continue;
            }

            String operator = token;
            Integer secondOperand = stack.pollLast();
            Integer firstOperand = stack.pollLast();
            if (operator.equals("+")) {
                stack.addLast(add(firstOperand, secondOperand));
            } else if (operator.equals("-")) {
                stack.addLast(subtract(firstOperand, secondOperand));
            } else if (operator.equals("*")) {
                stack.addLast(multiply(firstOperand, secondOperand));
            } else {
                stack.addLast(divide(firstOperand, secondOperand));
            }
        }

        return new Result(stack.pollLast());
    }

    private boolean isOperand(String token) {
        return token.matches("^[0-9]*$");
    }

}
