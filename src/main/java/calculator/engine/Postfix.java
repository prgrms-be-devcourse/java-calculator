package calculator.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Postfix {
    public Postfix() {}

    public List<String> makeToPostfix(String formula) throws IllegalAccessException {
        List<String> arr = new ArrayList<>();

        if(!isCorrectFormula(formula)) {
            throw new IllegalArgumentException("올바른 식을 입력해 주세요.");
        }

        Stack<String> stack = new Stack<>();
        String[] str = formula.replaceAll(" ", "").split("");

        for(int i = 0; i < str.length; i++) {
            String s = str[i];
            switch(s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(s)) {
                        arr.add(stack.pop());
                    }
                    stack.add(s);
                    break;
                case "(":
                    stack.add(s);
                    break;
                case ")":
                    while(!stack.isEmpty() && !stack.peek().equals("(")) {
                        arr.add(stack.pop());
                    }
                    stack.pop();
                    break;
                case " ":
                    break;
                default:
                    String temp = s;
                    for(int j = i; j < str.length - 1; j++) {
                        int n = str[j + 1].charAt(0) - '0';
                        if(n >= 0 && n <= 9) {
                            temp += String.valueOf(n);
                            i = j + 1;
                        } else {
                            break;
                        }
                    }
                    arr.add(temp);
                    break;
            }
        }

        while(!stack.isEmpty()) {
            arr.add(stack.pop());
        }

        return arr;
    }

    private boolean isCorrectFormula(String formula) {
        return Pattern.matches("^[0-9()*-/+]*$", formula.replaceAll(" ", ""));
    }

    public int priority(String operator) {
        switch (operator) {
            case "(":
            case ")":
                return 0;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }

        return -1;
    }
}
