package com.waterfogsw.converter;

import com.waterfogsw.domain.Algebraic;
import com.waterfogsw.domain.Operator;
import com.waterfogsw.domain.Parentheses;
import com.waterfogsw.exception.NotExistsOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class PostfixConverter implements Converter {

    /**
     * 후위표기식 변환 메서드
     *
     * @param infixTokens 중위표기식 토큰
     * @return 후위표기식 토큰
     */
    @Override
    public List<String> convert(List<String> infixTokens) throws NotExistsOperator {
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();

        for (String op : infixTokens) {
            if (!Algebraic.isOperator(op) && !Parentheses.isOperator(op)) {
                output.add(op);
            } else if (op.equals(Parentheses.LEFT.getSymbol())) {
                stack.add(op);
            } else if (op.equals(Parentheses.RIGHT.getSymbol())) {
                while (!stack.isEmpty() && !stack.peek().equals(Parentheses.LEFT.getSymbol())) {
                    output.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && comparePriority(stack.peek(), op)) {
                    output.add(stack.pop());
                }
                stack.add(op);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }
        return output;
    }

    private boolean comparePriority(String s1, String s2) throws NotExistsOperator {
        Operator op1 = getOperator(s1);
        Operator op2 = getOperator(s2);

        return op1.getPriority() >= op2.getPriority();
    }

    private Operator getOperator(String symbol) throws NotExistsOperator {
        Optional<Algebraic> findAlgebraic = Algebraic.findOperator(symbol);
        Optional<Parentheses> findParentheses = Parentheses.findOperator(symbol);

        if (findAlgebraic.isPresent()) {
            return findAlgebraic.get();
        } else if(findParentheses.isPresent()) {
            return findParentheses.get();
        } else {
            throw new NotExistsOperator();
        }
    }


}
