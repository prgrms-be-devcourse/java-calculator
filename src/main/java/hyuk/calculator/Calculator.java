package hyuk.calculator;

import hyuk.util.PatternValidator;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    public Result calculate(PostOrderFormula postOrderFormula) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : postOrderFormula.getPostOrderFormula()) {
            if (isOperand(token)) {
                stack.addLast(Integer.parseInt(token));
                continue;
            }

            String operator = token;
            Integer secondOperand = stack.pollLast();
            Integer firstOperand = stack.pollLast();
            stack.addLast(Operator.of(operator).apply(firstOperand, secondOperand));
        }

        return new Result(stack.pollLast());
    }

    private boolean isOperand(String token) {
        return PatternValidator.OperandPattern.matcher(token).matches();
    }

}
