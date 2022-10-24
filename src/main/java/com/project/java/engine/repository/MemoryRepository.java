package com.project.java.engine.repository;

import com.project.java.engine.data.SaveFormat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemoryRepository implements Repository{

    private List<SaveFormat> memoryRepository = new ArrayList<>();
    private int idx = 0;

    @Override
    public void save(Map<String ,Double> expression, String formattedResult) {
        for (String key : expression.keySet()) {
            memoryRepository.add(new SaveFormat(++idx, key + formattedResult));
        }
    }

    @Override
    public List<String> findAll() {
        List<String> resultList = new LinkedList<>();
        for (SaveFormat saveFormat : memoryRepository) {
            resultList.add(saveFormat.toString());
        }
        return resultList;
    }
}
