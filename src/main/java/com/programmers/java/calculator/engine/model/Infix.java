package com.programmers.java.calculator.engine.model;

import lombok.AllArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor
public class Infix implements Formula {
    private String[] infix;

    @Override
    public void forEach(Consumer<String> consumer) {
        for (String s : infix) {
            consumer.accept(s);
        }
    }
}
