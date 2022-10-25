package com.programmers.kwonjoosung.java.calculator.repository;

import java.util.Optional;

public interface Cache {
    void add(String[] expression, String result);
    Optional<String> getResult(String[] expression);
}
