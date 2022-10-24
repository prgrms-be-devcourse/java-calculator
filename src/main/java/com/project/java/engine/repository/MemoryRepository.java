package com.project.java.engine.repository;

import com.project.java.engine.data.ResultFormat;
import com.project.java.engine.data.SaveFormat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MemoryRepository implements Repository{

    private List<SaveFormat> memoryRepository = new ArrayList<>();
    private int idx = 0;

    @Override
    public void save(ResultFormat result) {
        memoryRepository.add(new SaveFormat(++idx, result.getExpression() + result.formatResult()));
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
