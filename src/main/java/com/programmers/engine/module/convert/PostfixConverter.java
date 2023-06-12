package com.programmers.engine.module.convert;

import com.programmers.engine.model.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {

    public List<String> convertInfixToPostfix(String expression) {
        String[] strArr = expression.split(" ");
        List<String> output = new ArrayList<>();
        Stack<String> st = new Stack<>();

        for (String now: strArr) {
            if (now.equals("+") || now.equals("-") || now.equals("*") || now.equals("/")) {
                while (!st.isEmpty() && Operator.matchOperator(st.peek()).getPriority() >= Operator.matchOperator(now).getPriority()) {
                    output.add(st.pop());
                }
                st.push(now);
                continue;
            }
            output.add(now);
        }
        while (!st.isEmpty()) output.add(st.pop());
        return output;
    }
}
