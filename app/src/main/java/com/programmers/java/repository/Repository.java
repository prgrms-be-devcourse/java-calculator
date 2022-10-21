package com.programmers.java.repository;

import java.util.List;

public interface Repository {
    void save(String formula, Integer result);

    List<String> findAllHistory();
}
