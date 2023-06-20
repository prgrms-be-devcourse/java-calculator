package com.devcourse.calc.converter;

import com.devcourse.calc.model.Operator;
import com.devcourse.calc.model.Token;

import java.util.List;
import java.util.Stack;

public class ConverterNoBracket extends Converter {

    @Override
    protected void processOperator(List<Token> result, Stack<Operator> operatorStack, char operatorChar) {
        Operator operator = Operator.find(operatorChar);
        if (operatorStack.size() > 0 && operator.isLowerPriority(operatorStack.peek())) {
            result.add(operatorStack.pop());
        }
        operatorStack.push(operator);
    }
}
