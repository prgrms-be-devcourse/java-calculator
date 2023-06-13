package com.programmers.domain;

import java.util.List;

public interface Repository {

    void save(String expression);

    List<String> findAll();
}
