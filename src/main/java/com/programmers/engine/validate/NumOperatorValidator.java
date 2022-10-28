package com.programmers.engine.validate;

import com.programmers.engine.stack.Bracket;
import com.programmers.engine.stack.Operator;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NumOperatorValidator implements Validator{
    private final AtomicInteger numCnt = new AtomicInteger();
    private final AtomicInteger operatorCnt =  new AtomicInteger();
    String operators = "+-*/";
    Map<String, String> operatorMap = Map.of(
            "+", Operator.PLUS.toString(),
            "-", Operator.MINUS.toString(),
            "*", Operator.MUL.toString(),
            "/", Operator.DIV.toString()
    );
    @Override
    public LinkedList<String> validate(LinkedList<String> linkedList) {
        LinkedList<String> newList = new LinkedList<>();
        numCnt.set(0); operatorCnt.set(0);
        linkedList.forEach(
                (element) -> {
                    if (operators.contains(element)) {
                        newList.add(operatorMap.get(element));
                        operatorCnt.getAndIncrement();
                    }
                    else  {
                        newList.add(element);
                        if (!element.equals(Bracket.OPEN.toString()) && !element.equals(Bracket.CLOSE.toString()))
                            numCnt.getAndIncrement();
                    }
                }
        );
        if (numCnt.get() - 1 != operatorCnt.get()) return new LinkedList<>();
        return newList;
    }
}
