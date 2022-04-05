package com.programmers.java.calculator.model;

import java.util.List;
import java.util.Optional;

public interface ExpressionRepository {
    boolean save(String expression, String result);
    List<String> findAll();
    String findById(String id);
    boolean cached(String expression);
    void clear();
}
