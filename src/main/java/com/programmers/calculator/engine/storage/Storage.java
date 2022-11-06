package com.programmers.calculator.engine.storage;

import java.util.Map;

public interface Storage {
    void save(String s);

    Map<Integer, String> findAll();
}
