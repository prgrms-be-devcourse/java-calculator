package org.example.calculation;

import org.example.io.IoManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArithmeticCalculation implements Calculation{
    @Override
    public int run(String input){
        return calculate(convertInput(input));
    }

    public String[] convertInput(String input) {
        input = input.replace("+", " + ");
        input = input.replace("-", " - ");
        input = input.replace("/", " / ");
        input = input.replace("*", " * ");
        input = input.replace("  ", " ");
        String[] str = input.split(" ");

        List<String> sb = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < str.length; i++){
            String cur = str[i];

            switch (cur){
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(cur)){
                        sb.add(stack.pop());
                    }
                    stack.push(cur);
                    break;
                default:
                    sb.add(cur);
            }
        }
        while (!stack.isEmpty()){
            sb.add(stack.pop());
        }

        String[] result = new String[sb.size()];
        for (int i = 0; i < sb.size(); i++){
            result[i] = sb.get(i);
        }

        return result;
    }

    private int priority(String operator) {
        if (operator.equals("+") || operator.equals("-")){
            return 1;
        } else if (operator.equals("*") || operator.equals("/")){
            return 2;
        }
        return -1;
    }

    public int calculate(String[] input){
        Stack<Integer> stack = new Stack<>();

        for (String cur : input){
            if (!cur.equals("+") && !cur.equals("-") && !cur.equals("*") && !cur.equals("/")){
                stack.push(Integer.parseInt(cur));
            }else {
                int targetNum1 = stack.pop();
                int targetNum2 = stack.pop();

                switch (cur){
                    case "+":
                        stack.push(targetNum2 + targetNum1);
                        break;
                    case "-":
                        stack.push(targetNum2 - targetNum1);
                        break;
                    case "*":
                        stack.push(targetNum2 * targetNum1);
                        break;
                    case "/":
                        stack.push(targetNum2 / targetNum1);
                        break;
                }
            }
        }
        return stack.pop();
    }

}
