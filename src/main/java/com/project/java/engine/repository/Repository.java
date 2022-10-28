package com.project.java.engine.repository;

import com.project.java.engine.data.ResultFormat;
import com.project.java.engine.data.SaveFormat;

import java.util.List;
import java.util.Map;

public interface Repository {
    void save(ResultFormat result);
    List<String> findAll();
}
