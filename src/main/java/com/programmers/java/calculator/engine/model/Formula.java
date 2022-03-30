package com.programmers.java.calculator.engine.model;

import java.util.function.Consumer;

public interface Formula {
    void forEach(Consumer<String> consumer);
}
