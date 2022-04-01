package me.programmers.calculator.engine;

public enum Operator {

    PLUS('+'),
    MINUS('-'),
    MUL('*'),
    DIV('/');

    private char op;

    Operator(char ch) {
        op = ch;
    }

    public static Operator getOperator(char ch) {
        switch (ch) {
            case '+':
                return PLUS;
            case '-':
                return MINUS;
            case '*':
                return MUL;
            case '/':
                return DIV;
            default:
                return null;
        }
    }

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
