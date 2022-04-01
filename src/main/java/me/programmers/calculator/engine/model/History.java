package me.programmers.calculator.engine.model;

import java.util.HashMap;
import java.util.Map;

public class History {

    private Map<Integer, String> memory = new HashMap<>();
    private int order = 1;

    public Map<Integer, String> getMemory() {
        return memory;
    }

    public synchronized void saveMemory(String problem, long result) {
        memory.put(order++, problem + "=" + result);
    }
}
