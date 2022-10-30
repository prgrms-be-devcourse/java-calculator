package org.programmers.java.calculator.service;


import org.programmers.java.calculator.memory.Memory;

import java.util.Optional;

public class CalculatorService{
    private final Memory memory = new Memory();

    public String calculationResult() {
        StringBuilder sb = new StringBuilder();
        memory.findAll().forEach(find -> {
            sb.append(find);
            sb.append("\n");
        });
        return sb.toString();
    }

    public Optional<String> find(String input) {
        return memory.find(input);
    }

    public void save(String input, String answer) {
        memory.save(input, answer);
    }
}
