package com.project.java.engine.repository;

import com.project.java.engine.data.SaveFormat;

import java.util.List;
import java.util.Map;

public interface Repository {
    void save(Map<String, Double> expression, String formattedResult);
    List<String> findAll();
}
