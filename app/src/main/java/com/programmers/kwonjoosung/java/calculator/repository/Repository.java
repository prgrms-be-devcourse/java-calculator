package com.programmers.kwonjoosung.java.calculator.repository;

import java.util.List;

public interface Repository {
    void save(String expression, String result);

    List<String> findAll();
}
