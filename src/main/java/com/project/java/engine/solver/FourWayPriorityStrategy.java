package com.project.java.engine.solver;

public class FourWayPriorityStrategy implements PriorityStrategy {
    @Override
    public int getPriority(String operator) {
        if (operator.equals("+") || operator.equals("-")) return 1;
        else return 2;
    }
}
