package org.example.repository;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HashMapRepository implements Repository {
    private long order = 1;
    private final HashMap<Long, String> results = new LinkedHashMap<>();

    @Override
    public void saveResult(String input, int output) {
        String result = input + " = " + output;
        results.put(order++, result);
    }

    @Override
    public void showSavedResults() {
        System.out.println();
        results.values().forEach(System.out::println);
        System.out.println();
    }
}
