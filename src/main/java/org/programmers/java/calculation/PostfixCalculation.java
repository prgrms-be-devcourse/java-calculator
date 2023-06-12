package org.programmers.java.calculation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PostfixCalculation {
    Deque<String> numberDeque = new ArrayDeque<>();

    public String calculate(List<String> postfixOperator){
        for(String operatorOrOperand : postfixOperator){
            numberAddInStack(operatorOrOperand);
            calculationResultAddInStack(operatorOrOperand);
        }

        return numberDeque.removeLast();
    }

    private void numberAddInStack(String operatorOrOperand){
        if(Operator.isNumber(operatorOrOperand)) {
            numberDeque.add(operatorOrOperand);
        }
    }

    private void calculationResultAddInStack(String operatorOrOperand) {
        if(Operator.isSymbol(operatorOrOperand).isPresent()){
            int num2 = Integer.parseInt(numberDeque.removeLast());
            int num1 = Integer.parseInt(numberDeque.removeLast());

            numberDeque.add(String.valueOf(Operator.arithmeticExpression(operatorOrOperand, num1, num2)));
        }
    }
}
