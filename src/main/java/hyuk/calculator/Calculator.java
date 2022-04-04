package hyuk.calculator;

import hyuk.util.PatternValidator;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    public Result calculates(PostOrderFormula postOrderFormula) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : postOrderFormula.getPostOrderFormula()) {
            calculate(stack, token);
        }

        return new Result(stack.pollLast());
    }

    private void calculate(Deque<Integer> stack, String token) {
        if (isOperand(token)) {
            stack.addLast(Integer.parseInt(token));
            return;
        }

        String operator = token;
        Integer secondOperand = stack.pollLast();
        Integer firstOperand = stack.pollLast();
        stack.addLast(Operator.of(operator).apply(firstOperand, secondOperand));
    }

    private boolean isOperand(String token) {
        return PatternValidator.OperandPattern.matcher(token).matches();
    }

}
