package com.project.java.engine.repository;

import com.project.java.engine.data.SaveFormat;

import java.util.List;
import java.util.Map;

public interface Repository {
    void save(Map<Integer, List<String>> expression);
    List<String> findAll();
}
