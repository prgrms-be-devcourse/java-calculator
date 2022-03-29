package org.programmers.calculator.postfixParser;

import org.programmers.calculator.TypeChecker.TypeChecker;

import java.util.*;

public class NumeralPostfixParser implements PostfixParser {

    private TypeChecker typeChecker;
    private final List<String> postfixExpression = new ArrayList<>();
    private Map<String, Integer> operatorRank;

    Deque<String> stack = new ArrayDeque<>();

    public NumeralPostfixParser(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
        operatorRank = typeChecker.getOperatorRank();
    }

    @Override
    public List<String> toPostfix(String[] input) throws IllegalArgumentException {

        boolean previousIsOperator = true;

        for (String each : input) {
            if (typeChecker.isOperand(each)) {
                previousIsOperator = false;
                postfixExpression.add(each);
            }
            else if (typeChecker.isOperator(each)) {
                if (previousIsOperator) throw new IllegalArgumentException("수식이 잘못되었습니다!");
                previousIsOperator = true;
                pushOperatorToStack(each);
            }
            else {
                throw new IllegalArgumentException("수식이 잘못되었습니다!");
            }
        }
        while(!stack.isEmpty()) {
            postfixExpression.add(stack.pop());
        }

        return postfixExpression;
    }

    private void pushOperatorToStack(String each) {
        if (stack.isEmpty()) {
            stack.push(each);
        }
        else {
            while (!stack.isEmpty() &&
                    operatorRank.get(stack.peek()) >= operatorRank.get(each)) {
                postfixExpression.add(stack.pop());
            }
            stack.push(each);
        }
    }

}
