package com.programmers.java.calculator.model;

import java.util.List;
import java.util.Optional;

public interface ExpressionRepository {
    void save(String expression, String result);
    List<String> findAll();
    String findById(String expression);
    boolean cached(String expression);
}
