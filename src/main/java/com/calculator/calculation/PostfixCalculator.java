package com.calculator.calculation;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;
public class PostfixCalculator {
    public int calculatePostfix(ArrayList<String> expression) {
        Stack<Integer> stack = new Stack<>();

        for (String cur : expression) {
            if (!isOperator(cur) && cur.matches("\\d+")){
                int operand = convertToNumber(cur);
                stack.push(operand);
            }
            else if(isOperator(cur) && !stack.isEmpty()){
                int op2 = stack.pop();
                int op1 = stack.pop();

                int temp = operate(op1, op2, cur);
                stack.push(temp);
            }
        }

        if(!stack.isEmpty()){
            int result = stack.pop();

            return result;
        }

        return 0;
    }

    private boolean isOperator(String value) {
        return Pattern.matches("[+\\-()*\\/]", value);
    }

    private int convertToNumber(String value) {
        try {
            int number = 0;
            number = Integer.parseInt(value);
            return number;
        } catch (NumberFormatException exception) {
            System.out.println("Invalid operand");
            return 0;
        }
    }

    private int operate(int operand1, int operand2, String operator){
        if(Pattern.matches("[+\\-*]", operator)){
            if(operator.equals("+")){
                return operand1 + operand2;
            }
            else if(operator.equals("-")){
                return operand1 - operand2;
            }
            else if(operator.equals("*")){
                return operand1 * operand2;
            }
        }
        else if(operator.equals("/")){
            try {
                int result = operand1/operand2;
                return result;
            }
            catch(ArithmeticException exception){
                System.out.println("Cannot divide into zero.");
                return 0;
            }
        }
        return 0;
    }
}
