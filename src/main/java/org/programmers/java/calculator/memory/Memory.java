package org.programmers.java.calculator.memory;


import java.util.*;

public class Memory {

    private final Map<String, String> cache = new HashMap<>();
    private final List<String> memory = new ArrayList<>();
    private Long id = 0L;

    public List<String> findAll() {
        return memory;
    }

    public Long save(String input, String answer) {
        memory.add(id + ". " + input + " = " + answer);
        cache.put(input, answer);
        return id++;
    }

    public Optional<String> findCache(String input) {
        return Optional.ofNullable(cache.get(input));
    }
}
