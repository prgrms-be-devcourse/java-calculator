package com.programmers.java.engine.repository;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class FormulaRepo {
    private final Map<String, Long> history = new HashMap<>();

    public void save(String formula, Long result) {
        history.put(formula, result);
    }

    public void inquire() {
        history.forEach((form, result) -> System.out.println(form + " = " + result));
        System.out.println("END !");
    }

    public int size() {
        return history.size();
    }
}
