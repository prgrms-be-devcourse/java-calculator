package com.programmers.java.engine.repository;

public interface MemoryRepository {

    void save(String formula, Long result);

    void findAll();

    int size();
}
