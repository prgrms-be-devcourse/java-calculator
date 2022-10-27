package com.project.java.engine.solver;

import java.util.Stack;

public interface PriorityStrategy {

    int getPriority(String operator);

    void operate(Stack<Double> stack, String element, double second, double first);
}
