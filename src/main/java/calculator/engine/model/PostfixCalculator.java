package calculator.engine.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public interface PostfixCalculator {
    static Double getResult(ArrayList<String> postfix) {
        Deque<Double> stack = new ArrayDeque<>();

        for (String token : postfix) {
            // 피연산자이면 스택에 push
            if (!Operator.isOperator(token)) {
                stack.push(Double.valueOf(token));
            }
            // 연산자이면 스택에서 2번 pop해서 연산하고 결과는 push
            else {
                Operator operator = Operator.getOperator(token).get();
                double first = stack.pop();
                double second = stack.pop();
                double value = operator.calculate(second, first);
                stack.push(value);
            }
        }

        return stack.pop();
    }
}
