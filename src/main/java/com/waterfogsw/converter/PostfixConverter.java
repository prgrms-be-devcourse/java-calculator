package com.waterfogsw.converter;

import com.waterfogsw.domain.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter implements Converter {

    @Override
    public List<String> convert(List<String> infixExpr) {
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();

        for (String op : infixExpr) {
            if (!Operator.isOperator(op)) {
                output.add(op);
            } else if (op.equals("(")) {
                stack.add(op);
            } else if (op.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && Operator.comparePri(stack.peek(), op)) {
                    output.add(stack.pop());
                }
                stack.add(op);
            }
        }
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }
        return output;
    }
}
