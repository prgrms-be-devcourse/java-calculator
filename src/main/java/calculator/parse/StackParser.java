package calculator.parse;

import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StackParser implements Parser {
    @Override
    public ArrayList<String> parse(String exp) {
        ArrayList<String> postfix = new ArrayList<>();
        Stack<Character> operator = new Stack<>();
        StringBuffer number = new StringBuffer();
        String noSpaceExp = exp.replaceAll("\s", "");

        for (int i = 0; i < noSpaceExp.length(); i++) {
            char c = noSpaceExp.charAt(i);
            switch (c) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                    while (i < noSpaceExp.length() && Character.isDigit(c)) {
                        number.append(c);
                        i++;
                        if (i < noSpaceExp.length())
                            c = noSpaceExp.charAt(i);
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
                default -> {}
            }
        }
        while (!operator.isEmpty()) {
            postfix.add(operator.pop().toString());
        }
        return postfix;
    }
    private int operatorPriority(char c) {
        switch (c) {
            case '*', '/' -> { return 2; }
            case '+', '-' -> { return 1; }
            default -> {return 0;}
        }
    }
}


