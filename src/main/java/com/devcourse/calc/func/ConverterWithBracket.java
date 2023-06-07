package com.devcourse.calc.func;

import com.devcourse.calc.model.Operator;
import com.devcourse.calc.model.Token;

import java.util.List;
import java.util.Stack;

public class ConverterWithBracket extends Converter {

    @Override
    protected void processOperator(List<Token> result, Stack<Operator> operatorStack, char operatorChar) {
        Operator operator = Operator.find(operatorChar);
        if (operatorStack.size() > 0 && operator.isLowerPriority(operatorStack.peek())) {
            result.add(operatorStack.pop());
        }
        operatorStack.push(operator);

        if (operator.isFinishBracket()) {
            clearBracketFormula(result, operatorStack);
        }
    }

    /**
     * 닫힘 괄호 만날 시
     * 괄호 안에 수식 우선 처리
     */
    private void clearBracketFormula(List<Token> result, Stack<Operator> operatorStack) {
        operatorStack.pop();
        while (!operatorStack.peek().isOpenBracket()) {
            result.add(operatorStack.pop());
        }
        operatorStack.pop();
    }
}
