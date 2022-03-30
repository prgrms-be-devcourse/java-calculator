package com.programmers.java.calculator.engine.model;


import lombok.AllArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor
public class Postfix implements Formula {
    private String[] postfix;

    @Override
    public void forEach(Consumer<String> consumer) {
        for (String s : postfix) {
            consumer.accept(s);
        }
    }
}
