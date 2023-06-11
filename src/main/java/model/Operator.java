package model;

import exception.NoSuchOperatorException;


import java.util.*;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 0, (num1, num2) -> num1 + num2),
    MINUS("-", 0, (num1, num2) -> num1 - num2),
    MULTIPLY("*", 1, (num1, num2) -> num1 * num2),
    DIVIDE("/", 1, (num1, num2) -> num1 / num2);

    private static final Deque<Operator> stack = new ArrayDeque<>();
    private final String operator;
    private final int precedence;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, int precedence, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.precedence = precedence;
        this.expression = expression;
    }

    public static boolean isEmpty() {
        return stack.isEmpty();
    }

    public static Operator peek() {
        return Optional.ofNullable(stack.peek())
                .orElseThrow(() -> new NoSuchElementException("[ERROR] 연산자 스택이 비어있습니다."));
    }

    public static void push(Operator operator) {
        stack.push(operator);
    }

    public static Operator pop() {
        try {
            return stack.pop();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("[ERROR] 연산자 스택이 비어있습니다.");
        }
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(elem -> elem.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new NoSuchOperatorException("[ERROR] 옳지 않은 연산자입니다."));
    }

    public int getPrecedence() {
        return precedence;
    }

    public int applyCalculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
