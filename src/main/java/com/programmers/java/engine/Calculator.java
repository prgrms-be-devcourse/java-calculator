package com.programmers.java.engine;

import com.programmers.java.engine.domain.Expression;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public Double calculate(String inputStr) {
        return doAddAndSubtract(doMultiplyAndDivide(parseInput(inputStr)));
    }

    public Expression parseInput(String inputStr){
        String operatorPattern = "[\\+\\*-/]";
        Double[] operands = Arrays.stream(inputStr.split(operatorPattern)).map(Double::valueOf).toArray(Double[]::new);
        Matcher operatorMatcher = Pattern.compile(operatorPattern).matcher(inputStr);
        String[] operators = new String[operands.length - 1];
        int i=0;
        while(operatorMatcher.find()){
            operators[i++] = operatorMatcher.group();
        }
        return new Expression(operators, operands);
    }

   public Expression doMultiplyAndDivide(Expression expression){
        String[] operators = expression.getOperators();
        Double[] operands = expression.getOperands();

        Stack<Double> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        operandStack.push(operands[0]);
        for(int i=0; i < operators.length; i++){
            if(operators[i].equals("*") || operators[i].equals("/")){
                Double prevVal = operandStack.pop();
                Double curVal = operands[i + 1];
                if(operators[i].equals("*")){
                    operandStack.push(prevVal * curVal);
                }
                else{
                    operandStack.push(prevVal / curVal);
                }
            }
            else{
                operandStack.push(operands[i + 1]);
                operatorStack.push(operators[i]);
            }
        }
        return new Expression(operatorStack.toArray(String[]::new), operandStack.toArray(Double[]::new));
    }

    public Double doAddAndSubtract(Expression expression){
        String[] operators = expression.getOperators();
        Double[] operands = expression.getOperands();

        Double result = operands[0];
        for(int i=0; i < operators.length; i++){
            if(operators[i].equals("+")){
                result += operands[i + 1];
            }
            else{
                result -= operands[i + 1];
            }
        }
        return result;
    }
}
