package com.programmers.blackdog.service;

import java.util.List;

public interface Service {
    int calculate(String expression);

    void save(String expression, int result);

    List<String> findAll();

}
