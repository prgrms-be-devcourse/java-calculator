package com.programmers.java.engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
public class History {
    private Map<String, Double> equations = new HashMap<>();

    public void addEquation(String expression, Double answer) {
        equations.put(expression, answer);
    }
}
