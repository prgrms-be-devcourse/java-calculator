package com.programmers.caculation.parser;

import com.programmers.caculation.dto.ParseResponseDto;
import com.programmers.caculation.model.NumberAndOperator;
import com.programmers.util.Operator;

import java.util.*;

public class PostfixParser implements Parser {
    @Override
    public ParseResponseDto parse(Collection<NumberAndOperator> numOrOp) {
        Stack<Character> operatorStack = new Stack<>();
        List<NumberAndOperator> parseResult = new ArrayList<>();
        for (NumberAndOperator o : numOrOp) {
            if (o.isOperator()) {
                Character myOperator = o.getOperator();
                try {
                    Character stackTop = operatorStack.peek();
                    int myPriority = Operator.getPriority(myOperator);
                    int stackTopPriority = Operator.getPriority(stackTop);
                    if (myPriority < stackTopPriority) {
                        operatorStack.push(myOperator);
                    } else {
                        parseResult.add(new NumberAndOperator(operatorStack.pop()));
                        operatorStack.push(myOperator);
                    }
                } catch (EmptyStackException e) {
                    operatorStack.push(myOperator);
                }

            } else if (o.isNumber()) {
                parseResult.add(o);
            }
        }
        while (operatorStack.size() != 0) {
            parseResult.add(new NumberAndOperator(operatorStack.pop()));
        }
        return new ParseResponseDto(parseResult);
    }
}
