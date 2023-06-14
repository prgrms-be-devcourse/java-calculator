package com.programmers.domain;

import com.programmers.enumtype.Operator;
import com.programmers.util.Arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Supplier;

public class PostfixConverter {
    private List<String> postfixExpression;
    private Stack<Operator> operators;

    public List<String> convert(List<String> tokenized) {
        postfixExpression = new ArrayList<>();
        operators = new Stack<>();

        for (String token : tokenized) {
            if (Arithmetic.isNumber(token)) {
                postfixExpression.add(token);
            } else {
                Operator operator = Operator.getValue(token);
                popAndAddOperatorsToExpression(() -> operator.comparePriorityTo(operators.peek()));
                operators.push(operator);
            }
        }
        popAndAddOperatorsToExpression(() -> false);

        return postfixExpression;
    }

    private void popAndAddOperatorsToExpression(Supplier<Boolean> breakCondition) {
        while (!operators.isEmpty()) {
            if (breakCondition.get()) {
                break;
            }
            Operator operator = operators.pop();
            postfixExpression.add(operator.toString());
        }
    }
}
