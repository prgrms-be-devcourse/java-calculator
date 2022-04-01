package calculator.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Postfix {
    public Postfix() {}

    public List<String> makeToPostfix(String formula) throws IllegalAccessException {
        if(!isCorrectFormula(formula)) {
            throw new IllegalArgumentException();
        }

        List<String> arr = new ArrayList<>();
        Stack<String> stack = new Stack<>();

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
                        for (int j = 0; j < s.length(); j++) {
                            if (s.charAt(j) != '(') {
                                arr.add(s.substring(j));
                                break;
                            }

                            stack.push("(");
                        }
                    } else if (s.contains(")")) {
                        while (!stack.isEmpty() && !stack.peek().equals("(")) {
                            arr.add(stack.pop());
                        }

                        stack.pop();
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

    public boolean isCorrectFormula(String formula) {
        return Pattern.matches("^[0-9()*-/+]*$", formula.trim().replaceAll(" ", ""));
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
