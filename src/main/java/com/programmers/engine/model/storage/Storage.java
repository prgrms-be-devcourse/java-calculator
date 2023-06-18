package com.programmers.engine.model.storage;

import java.util.List;

public interface Storage {
    List<List<String>> findAll();

    void save(String calculationCommand, Integer calculationResult);
}
