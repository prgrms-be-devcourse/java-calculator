package com.programmers.engine.model;

import java.util.List;

public interface Storage {
    List<String> findAll();

    void save(String calculationCommand, Integer calculationResult);
}
