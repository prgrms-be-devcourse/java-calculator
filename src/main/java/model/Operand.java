package model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Operand {
    private final Deque<Integer> stack;

    public Operand() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int number) {
        stack.push(number);
    }

    public int pop() {
        return stack.pop();
    }
}
