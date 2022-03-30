package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Infix;
import com.programmers.java.calculator.engine.model.Postfix;

import java.util.*;

public class PostfixConverter {
    private final HashMap<String, Integer> priorityMap = new HashMap<>() {{
        put("+", 1);
        put("-", 1);
        put("*", 2);
        put("/", 2);
    }};


    public Postfix convertInfixToPostfix(Infix infix) {
        Deque<String> deque = new ArrayDeque<>();
        List<String> postfix = new ArrayList<>();
        infix.forEach((s) -> {
            try {
                Integer num = Integer.parseInt(s);
                postfix.add(s);
            } catch (NumberFormatException e) {
                while (!deque.isEmpty() && priorityMap.get(s) <= priorityMap.get(deque.getFirst())) {
                    postfix.add(deque.removeFirst());
                }
                deque.addFirst(s);
            }
        });
        while (!deque.isEmpty()) {
            postfix.add(deque.removeFirst());
        }
        return new Postfix(postfix.toArray(new String[0]));
    }
}
