package com.programmers.domain;

import com.programmers.enumtype.Operator;
import com.programmers.util.Arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BooleanSupplier;

public class PostfixConverter {
    public static List<String> convert(List<String> tokenized) {
        List<String> postfixExpression = new ArrayList<>();
        Stack<Operator> operators = new Stack<>();

        for (String token : tokenized) {
            if (Arithmetic.isNumber(token)) {
                postfixExpression.add(token);
            } else {
                Operator operator = Operator.getValue(token);

                List<Operator> poppedOperators =
                        popOperators(operators, () -> operator.comparePriorityTo(operators.peek()));
                addOperatorsToExpression(poppedOperators, postfixExpression);

                operators.push(operator);
            }
        }
        List<Operator> remainedOperators = popOperators(operators, () -> false);
        addOperatorsToExpression(remainedOperators, postfixExpression);

        return postfixExpression;
    }

    private static List<Operator> popOperators(Stack<Operator> operators, BooleanSupplier breakCondition) {
        List<Operator> poppedOperators = new ArrayList<>();
        while (!operators.isEmpty()) {
            if (breakCondition.getAsBoolean()) {
                break;
            }
            poppedOperators.add(operators.pop());
        }

        return poppedOperators;
    }

    private static void addOperatorsToExpression(List<Operator> operators, List<String> postfixExpression) {
        postfixExpression.addAll(
                operators.stream()
                        .map(Operator::toString)
                        .toList()
        );
    }
}
