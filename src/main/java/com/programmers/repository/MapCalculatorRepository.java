package com.programmers.repository;

import com.programmers.model.ExpressionResult;
import com.programmers.util.IdGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapCalculatorRepository implements CalculatorRepository{
    private final Map<Integer, ExpressionResult> calculatorRepository = new LinkedHashMap<>();
    private static final IdGenerator idGenerator = new IdGenerator();

    public MapCalculatorRepository(){
    }

    public int save(ExpressionResult dto) {
        int key = idGenerator.generateId();
        calculatorRepository.put(key, dto);
        return key;
    }

    public List<ExpressionResult> findAll() {
        List<ExpressionResult> list = new ArrayList<>();
        list.addAll(calculatorRepository.values());
        return list;
    }

}