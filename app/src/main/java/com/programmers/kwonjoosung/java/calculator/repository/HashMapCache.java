package com.programmers.kwonjoosung.java.calculator.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HashMapCache implements Cache {
    private final Map<String,String> CACHE = new HashMap<>();
    @Override
    public void add(String[] expression, String result) {
        String key = String.join(" ",expression);
        if(!CACHE.containsKey(key)) CACHE.put(key,result);
    }
    @Override
    public Optional<String> getResult(String[] expression) {
        String key = String.join(" ",expression);
        if(!CACHE.containsKey(key)) return Optional.empty();
        return Optional.of(CACHE.get(key));
    }
}
