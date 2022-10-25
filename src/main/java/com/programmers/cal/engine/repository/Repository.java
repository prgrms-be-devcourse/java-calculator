package com.programmers.cal.engine.repository;

import java.util.List;

public interface Repository {
    void save(String inputString, String result);

    List<String> findAll();
}
