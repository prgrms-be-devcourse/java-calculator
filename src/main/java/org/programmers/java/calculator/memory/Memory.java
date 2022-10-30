package org.programmers.java.calculator.memory;


import java.util.*;

public class Memory {

    private final HashMap<String, String> cache = new HashMap<>();
    private final ArrayList<String> memory = new ArrayList<>();
    private Long id = 0L;

    public ArrayList<String> findAll() {
        return memory;
    }

    public Long save(String input, String answer) {
        memory.add(id + ". " + input + " = " + answer);
        cache.put(input, answer);
        return id++;
    }

    public Optional<String> find(String input) {
        return Optional.ofNullable(cache.get(input));
    }
}
