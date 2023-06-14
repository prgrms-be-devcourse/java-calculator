package com.programmers.domain;

import com.programmers.enumtype.Operator;
import com.programmers.util.Arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BooleanSupplier;

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

                List<Operator> poppedOperators =
                        popOperators(() -> operator.comparePriorityTo(operators.peek()));
                addOperatorsToExpression(poppedOperators);

                operators.push(operator);
            }
        }
        List<Operator> remainedOperators = popOperators(() -> false);
        addOperatorsToExpression(remainedOperators);

        return postfixExpression;
    }

    private List<Operator> popOperators(BooleanSupplier breakCondition) {
        List<Operator> poppedOperators = new ArrayList<>();
        while (!operators.isEmpty()) {
            if (breakCondition.getAsBoolean()) {
                break;
            }
            poppedOperators.add(operators.pop());
        }

        return poppedOperators;
    }

    private void addOperatorsToExpression(List<Operator> operators) {
        postfixExpression.addAll(
                operators.stream()
                        .map(Operator::toString)
                        .toList()
        );
    }
}
