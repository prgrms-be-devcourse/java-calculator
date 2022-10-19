package calculator.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Postfix {
    public Postfix() {}
    static Stack<String> stack;
    static List<String> arr;

    public List<String> makeToPostfix(String formula) throws IllegalArgumentException {
        if(!isCorrectFormula(formula)) {
            throw new IllegalArgumentException();
        }

        arr = new ArrayList<>();
        stack = new Stack<>();

        String[] splitFormula = formula.trim().replaceAll(" +", " ").split(" ");

        for (String s : splitFormula) {
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
                default:
                    if (s.contains("(")) {
                        openingParenthesis(s);
                    } else if (s.contains(")")) {
                        closingParenthesis(s);
                    } else {
                        arr.add(s);
                    }

                    break;
            }
        }

        while(!stack.empty()) {
            arr.add(stack.pop());
        }

        return arr;
    }

    private void openingParenthesis(String s) {
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) != '(') {
                arr.add(s.substring(j));
                break;
            }

            stack.push("(");
        }
    }
    private void closingParenthesis(String s) {
        int idx = s.indexOf(")");
        arr.add(s.substring(0, idx));
        int count = s.substring(idx).length();
        for(int i = 0; i < count; i++) {
            while (!stack.isEmpty() && !stack.peek().equals("(")) {
                arr.add(stack.pop());
            }

            stack.pop();
        }
    }

    public boolean isCorrectFormula(String formula) {
        return Pattern.matches("^[0-9()*-/+]*$", formula.trim().replaceAll(" ", ""));
    }

    public int priority(String operator) throws IllegalArgumentException {
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
            default:
                break;
        }

        throw new IllegalArgumentException();
    }
}
