package com.programmers.engine.validate;

import com.programmers.engine.stack.Bracket;
import com.programmers.engine.stack.Operator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NumOperatorValidator implements Validator{
    private final AtomicInteger numCnt = new AtomicInteger();
    private final AtomicInteger operatorCnt =  new AtomicInteger();
    String operators = "+-*/";
    Map<String, Operator> operatorMap = Map.of(
            "+", Operator.PLUS,
            "-", Operator.MINUS,
            "*", Operator.MUL,
            "/", Operator.DIV
    );
    @Override
    public LinkedList<String> validate(LinkedList<String> linkedList) {
        LinkedList<String> newList = new LinkedList<>();
        numCnt.set(0); operatorCnt.set(0);
        linkedList.forEach(
                (word) -> {
                    if (operators.contains(word)) {
                        newList.add(operatorMap.get(word).toString());
                        operatorCnt.getAndIncrement();
                    }
                    else  {
                        newList.add(word);
                        if (!word.equals(Bracket.OPEN.toString()) && !word.equals(Bracket.CLOSE.toString()))
                            numCnt.getAndIncrement();
                    }
                }
        );
        if (numCnt.get() - 1 != operatorCnt.get()) return new LinkedList<>();
        return newList;
    }
}
