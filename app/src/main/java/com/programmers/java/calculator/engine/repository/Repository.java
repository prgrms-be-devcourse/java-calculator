package com.programmers.java.calculator.engine.repository;

public interface Repository {
    void save(String string);

    void printLog();

    String findById(Long id);
}
