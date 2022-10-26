package com.programmers.kwonjoosung.java.calculator.repository;

import java.util.Optional;

public interface Repository {
    void save(String[] expression, String result);

    Optional<String> getHistory(int index);
}
