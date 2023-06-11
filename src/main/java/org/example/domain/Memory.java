package org.example.domain;

import java.util.HashMap;

public class Memory {
    private HashMap<String, Integer> map = new HashMap<>();

    void save(String infixExpression, Integer result) {
        map.put(infixExpression, result);
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }
}
