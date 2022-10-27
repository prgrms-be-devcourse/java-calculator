package com.project.java.engine.solver;

import java.util.Stack;

public class FourWayPriorityStrategy implements PriorityStrategy {

    @Override
    public int getPriority(String operator) {
        if (operator.equals("+") || operator.equals("-")) return 1;
        else return 2;
    }

    @Override
    public void operate(Stack<Double> stack, String element, double second, double first) {
        switch (element) {
            case "+" -> stack.push(first + second);
            case "-" -> stack.push(first - second);
            case "*" -> stack.push(first * second);
            case "/" -> stack.push(first / second);
        }
    }
}
