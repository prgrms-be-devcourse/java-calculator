package calculator.engine.model;

import java.util.ArrayList;
import java.util.Stack;

public interface PostfixCalculator {
    static Double getResult(ArrayList<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String s : postfix) {
            // 피연산자이면 스택에 push
            if (!Operator.isOperator(s)) {
                stack.push(Double.valueOf(s));
            }
            // 연산자이면 스택에서 2번 pop해서 연산하고 결과는 push
            else {
                Operator operator = Operator.getOperator(s).get();
                double first = stack.pop();
                double second = stack.pop();
                double value = operator.calculate(second, first);
                stack.push(value);
            }
        }

        return stack.pop();
    }
}
