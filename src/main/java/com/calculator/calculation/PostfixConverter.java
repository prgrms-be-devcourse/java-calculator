package com.calculator.calculation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
public class PostfixConverter {
    private ArrayList<String> postfixExpression = new ArrayList<>(); // 후위표기식 저장
    private String operandPattern = "\\d+";

    private boolean isOperand(String value){
        if(value.matches(operandPattern)){
            return true;
        }
        else{
            return false;
        }
    }

    public void convertToPostfix(String expression){
        String infixExpression[] = expression.split(" ");
        Stack<String> stack = new Stack<>();

        for(String cur: infixExpression){
            if(isOperand(cur)){
                postfixExpression.add(cur);
            }
            else if(cur.equals("(")) {
                stack.push(cur);
            }
            else if(cur.equals(")")){
                while(!stack.isEmpty()) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        break;
                    }
                    else {
                        postfixExpression.add(stack.pop());
                    }
                }
            }
            else if(cur.equals("*")||cur.equals("/")){
                stack.push(cur);
            }
            else if(cur.equals("+")||cur.equals("-")){
                if(stack.isEmpty()){
                    stack.push(cur);
                }
                else{
                    while(!stack.isEmpty()){
                        if(stack.peek().equals("(")){
                            stack.push(cur);
                            break;
                        }
                        else {
                            postfixExpression.add(stack.pop());
                        }
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) {
                throw new IllegalArgumentException("Invalid expression");
            }
            postfixExpression.add(stack.pop());
        }
    }

    public void printPostfix(){
        System.out.println(postfixExpression.toString());
    }

    public ArrayList<String> getPostfix(){
        return postfixExpression;
    }
}
