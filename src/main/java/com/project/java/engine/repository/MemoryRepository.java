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
    public void save(Map<Integer, List<String>> expression) {
        for (Integer key : expression.keySet()) {
            StringBuffer sb = new StringBuffer();
            for(String numOper : expression.get(key)) {
                sb.append(numOper).append(" ");
            }
            sb.append("= ").append(key);
            memoryRepository.add(new SaveFormat(++idx, sb.toString()));
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
