package com.programmers.engine.module.convert;

import com.programmers.engine.model.Operator;

import java.util.List;
import java.util.Stack;

public class AnswerConverter {
    public int convertPostfixToAnswer(List<String> list) {
        Stack<Integer> st = new Stack<>();
        for (String now : list) {
            if (!now.equals("+") && !now.equals("-") && !now.equals("*") && !now.equals("/")) {
                st.push(Integer.parseInt(now));
                continue;
            }
            Operator operator = Operator.matchOperator(now);
            int x = st.pop();
            int y = st.pop();
            st.push(operator.calculate(x, y));
        }
        return st.pop();
    }
}
