package com.programmers.engine.validate;

import com.programmers.engine.stack.Bracket;
import com.programmers.engine.stack.Operator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NumOperatorValidator implements Validator{
    AtomicInteger numCnt = new AtomicInteger();
    AtomicInteger OperatorCnt =  new AtomicInteger();
    String Operators = "+-*/";
    Map<String, Operator> operatorMap = Map.of(
            "+", Operator.PLUS,
            "-", Operator.MINUS,
            "*", Operator.MUL,
            "/", Operator.DIV
    );
    @Override
    public LinkedList<String> validate(LinkedList<String> linkedList) {
        LinkedList<String> newList = new LinkedList<>();
        numCnt.set(0); OperatorCnt.set(0);
        linkedList.forEach(
                (l) -> {
                    if (Operators.contains(l)) {
                        newList.add(operatorMap.get(l).toString());
                        OperatorCnt.getAndIncrement();
                    }
                    else  {
                        newList.add(l);
                        if (!l.equals(Bracket.OPEN.toString()) && !l.equals(Bracket.CLOSE.toString()))
                            numCnt.getAndIncrement();
                    }
                }
        );
        if (numCnt.get() - 1 != OperatorCnt.get()) return new LinkedList<>();
        return newList;
    }
}
