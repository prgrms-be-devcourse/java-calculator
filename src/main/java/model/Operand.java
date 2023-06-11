package model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Operand {
    private final Deque<Integer> stack;

    public Operand() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int number) {
        stack.push(number);
    }

    public int pop() {
        try {
            return stack.pop();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("[ERROR] 피연산자 스택이 비어있습니다.");
        }

    }
}
