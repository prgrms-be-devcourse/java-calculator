package hyuk.calculator;

import static hyuk.calculator.Operator.DIVIDE;
import static hyuk.calculator.Operator.MINUS;
import static hyuk.calculator.Operator.MULTIPLY;
import static hyuk.calculator.Operator.PLUS;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

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
                stack.addLast(PLUS.calculate(firstOperand, secondOperand));
            } else if (operator.equals("-")) {
                stack.addLast(MINUS.calculate(firstOperand, secondOperand));
            } else if (operator.equals("*")) {
                stack.addLast(MULTIPLY.calculate(firstOperand, secondOperand));
            } else {
                stack.addLast(DIVIDE.calculate(firstOperand, secondOperand));
            }
        }

        return new Result(stack.pollLast());
    }

    private boolean isOperand(String token) {
        return token.matches("^[0-9]*$");
    }

}
