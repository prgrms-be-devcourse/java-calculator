package org.programmers.java.calculator.util.postfix;

import org.programmers.java.calculator.model.Operator;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixCalculator {

    public double calculate(String postfixExpression){

        Deque<Double> deque = new ArrayDeque<>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char c = postfixExpression.charAt(i);

            if(Character.isDigit(c)){
                deque.push((double) Character.getNumericValue(c));
                continue;
            }

            Operator operator = Operator.from(c);
            checkValid(operator);//유효한 연산자인지 검사하고, 아닌 경우 예외 발생

            Double pop1 = deque.pollFirst();
            Double pop2 = deque.pollFirst();
            deque.addFirst(operator.execute(pop2, pop1));// 1/2 -> 12/ 이며, 따라서 더 먼저 들어온 수를 먼저 계산해야 함

        }

        if(deque.size() != 1) throw new IllegalStateException("수식에 오류가 있습니다");
        return deque.pollFirst();
    }

    private void checkValid(Operator inputOperator) {
        if(Operator.NOT_DEFINED.equals(inputOperator))  throw new IllegalStateException();
    }
}
