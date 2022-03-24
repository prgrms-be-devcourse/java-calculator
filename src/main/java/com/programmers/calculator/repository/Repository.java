package com.programmers.calculator.repository;

import java.util.List;

public interface Repository<T> {
    void save(T vo);

    List<T> findAll();
}
