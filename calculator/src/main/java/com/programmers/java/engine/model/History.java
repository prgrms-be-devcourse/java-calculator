package com.programmers.java.engine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
public class History {
    private Map<String, Answer> equations = new HashMap<>();

    public void addEquation(String expression, Answer answer) {
        equations.put(expression, answer);
    }

}
