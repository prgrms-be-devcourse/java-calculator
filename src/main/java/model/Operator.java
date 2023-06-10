package model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Operator {
    private final Deque<OperatorType> stack;

    public Operator() {
        this.stack = new ArrayDeque<>();
    }

    public void push(char operator) {
        OperatorType operatorType = OperatorType.getOperator(String.valueOf(operator));
        stack.push(operatorType);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public OperatorType peekOperator() {
        return stack.peek();
    }

    public OperatorType pop() {
        return stack.pop();
    }
}
