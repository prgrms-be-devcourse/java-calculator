package com.programmers.java.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Repository {
    private HashMap<String, BigDecimal> history = new HashMap<>();

    public Map<String, BigDecimal> showAll() {
        return history;
    }

    public void save(String postExp, BigDecimal bigDecimal) {
        history.put(postExp, bigDecimal);
    }
}
