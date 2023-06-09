package org.example;

import java.util.Stack;

public class Calculate implements CalOrder{
    private String expression;
    Stack<String> expressionStack = new Stack<>();
    ExpressionRepository repository = new ExpressionRepository();
    int result = 0;

    public Calculate(String expression) {
        this.expression = expression;
        String[] expressionArr = expression.split(" ");
        for (String inputVal : expressionArr) {
            expressionStack.add(inputVal);
        }
    }

    public void calculate(){
        calPriorityFirst();
        calPrioritySecond();
    }

    @Override
    public void calPriorityFirst() {
        for (int i = 1; i < expressionStack.size(); i+=2) {
            if (expressionStack.get(i).equals("*")) {
                multiply(i);
                i -= 2;
            } else if (expressionStack.get(i).equals("/")) {
                divide(i);
                i -= 2;
            }
        }
    }

    @Override
    public void calPrioritySecond() {
        result = Integer.parseInt(expressionStack.get(0));
        for (int i = 1; i < expressionStack.size(); i += 2) {
            if (expressionStack.get(i).equals("+")) {
                result += Integer.parseInt(expressionStack.get(i + 1));
            } else {
                result -= Integer.parseInt(expressionStack.get(i + 1));
            }
        }
        System.out.println(result);
        repository.save(expression,result);
    }

    public void multiply(int idx){
        result = Integer.parseInt(expressionStack.get(idx - 1)) * Integer.parseInt(expressionStack.get(idx + 1));
        expressionStack.add(idx - 1, String.valueOf(result));
        expressionStack.remove(idx);
        expressionStack.remove(idx);
        expressionStack.remove(idx);
    }

    public void divide(int idx) {
        result = Integer.parseInt(expressionStack.get(idx - 1)) / Integer.parseInt(expressionStack.get(idx + 1));
        expressionStack.add(idx - 1, String.valueOf(result));
        expressionStack.remove(idx);
        expressionStack.remove(idx);
        expressionStack.remove(idx);
    }
}
