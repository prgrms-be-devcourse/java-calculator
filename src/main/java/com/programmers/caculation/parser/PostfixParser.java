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
            addMemberToResultConsiderPriority(operatorStack, parseResult, o);
        }
        addOperatorToResultThatRemainsInOperatorStack(operatorStack, parseResult);
        return new ParseResponseDto(parseResult);
    }

    private void addMemberToResultConsiderPriority(Stack<Character> operatorStack, List<NumberAndOperator> parseResult, NumberAndOperator o) {
        if (o.isOperator()) {
            addOperatorToResultConsiderPriorityUsingStack(operatorStack, parseResult, o.getOperator());

        } else if (o.isNumber()) {
            addNumberToResult(parseResult, o.getNumber());
        }
    }

    private void addOperatorToResultConsiderPriorityUsingStack(Stack<Character> operatorStack, List<NumberAndOperator> parseResult, Character myOperator) {
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
    }
    private void addNumberToResult(List<NumberAndOperator> parseResult, Double myNumber){
        parseResult.add(new NumberAndOperator(myNumber));
    }
    private void addOperatorToResultThatRemainsInOperatorStack(Stack<Character> operatorStack, List<NumberAndOperator> parseResult) {
        while (operatorStack.size() != 0) {
            parseResult.add(new NumberAndOperator(operatorStack.pop()));
        }
    }
}
