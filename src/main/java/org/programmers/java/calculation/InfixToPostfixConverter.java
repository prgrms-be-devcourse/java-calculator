package org.programmers.java.calculation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InfixToPostfixConverter {
    List<String> postfixOperator = new ArrayList<>();
    Deque<String> operatorDeque = new ArrayDeque<>();

    public List<String> convert(String[] formulaList){
        for(String operatorOrOperand : formulaList){
            operandAddInPostfix(operatorOrOperand);
            checkOperatorToAddPostfix(operatorOrOperand);
        }
        while(operatorDeque.size() > 0){
            postfixOperator.add(operatorDeque.removeLast());
        }

        return postfixOperator;
    }

    private void operandAddInPostfix(String operatorOrOperand){
        if(Operator.isNumber(operatorOrOperand)){
            postfixOperator.add(operatorOrOperand);
        }
    }

    private void checkOperatorToAddPostfix(String operatorOrOperand) {
        if (Operator.isSymbol(operatorOrOperand).isPresent()) {
            checkOperatorStackAndCompare(operatorOrOperand);
        }
    }

    private void checkOperatorStackAndCompare(String operatorOrOperand){
        while (!operatorDeque.isEmpty() && comparePriorities(operatorOrOperand)) {
            postfixOperator.add(operatorDeque.removeLast());
        }

        operatorDeque.add(operatorOrOperand);
    }

    private boolean comparePriorities(String operatorOrOperand){
        return Operator.comparePriorities(operatorDeque.peekLast(), operatorOrOperand);
    }
}
