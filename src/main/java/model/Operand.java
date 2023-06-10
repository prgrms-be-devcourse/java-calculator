package model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Operand {
    private final Deque<Integer> stack;

    public Operand() {
        this.stack = new ArrayDeque<>();
    }

    public void pushOperand(String number) {
        stack.push(Integer.parseInt(number));
    }
}
