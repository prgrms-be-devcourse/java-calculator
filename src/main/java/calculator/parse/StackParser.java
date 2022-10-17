package calculator.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StackParser implements Parser {
    public static final String WRONG_ARGUMENTS = "잘못된 값이 들어왔습니다.";
    public static final String OPERAND_NOT_MATCH = "연산자와 피연산자의 개수가 맞지 않습니다.";
    @Override
    public ArrayList<String> parse(String exp) {
        ArrayList<String> postfix = new ArrayList<>();
        Stack<Character> operator = new Stack<>();
        StringBuilder number = new StringBuilder();

        exp = exp.replaceAll("\s", "");
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            switch (c) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                    while (i < exp.length() && Character.isDigit(c)) {
                        number.append(c);
                        i++;
                        if (i < exp.length())
                            c = exp.charAt(i);
                    }
                    postfix.add(number.toString());
                    number.delete(0, number.length());
                    i--;
                }
                case '+', '-', '*', '/' -> {
                    while (!operator.isEmpty() && operatorPriority(operator.peek()) >= operatorPriority(c)) {
                        postfix.add(operator.pop().toString());
                    }
                    operator.push(c);
                }
                default -> {
                    throw new IllegalArgumentException(WRONG_ARGUMENTS); }
            }
        }
        while (!operator.isEmpty()) {
            postfix.add(operator.pop().toString());
        }
        if (!validCheck(postfix)) {
            throw new IllegalArgumentException(OPERAND_NOT_MATCH);
        }
        return postfix;
    }

    @Override
    public boolean validCheck(ArrayList<String> exp) {
        int operator = 0;
        int operand = 0;
        for (String op : exp) {
            switch (op) {
                case "+", "-", "*", "/" -> { operator++; }
                default -> { operand++; }
            }
        }
        return operator + 1 == operand;
    }

    private int operatorPriority(char c) {
        switch (c) {
            case '*', '/' -> { return 2; }
            case '+', '-' -> { return 1; }
            default -> {return 0;}
        }
    }
}


