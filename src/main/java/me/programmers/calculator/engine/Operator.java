package me.programmers.calculator.engine;

public class Operator {

    public static int getPriority(char op) {
        if (op == '*' || op == '/')
            return 0;
        else
            return 1;
    }

    public static boolean isOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }
}
