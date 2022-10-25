package com.programmers.util;

public class Operator {
    public static final int getPriority(Character c) {
        int priority = -1;
        switch (c) {
            case '+', '-' -> priority = 4;
            case '*', '/' -> priority = 3;
        }
        return priority;
    }

    public static final double caculate(Character operator, double left, double right) {
        double result = 0;
        switch (operator) {
            case '+' -> result = left + right;
            case '-' -> result = left - right;
            case '*' -> result = left * right;
            case '/' -> result = left / right;
        }
        return result;
    }

}
