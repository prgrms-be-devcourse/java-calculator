package org.programmers.repository;

import org.programmers.entity.ResultModel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CalculatorRepository implements Repository{
    private Map<Long, ResultModel> map = new ConcurrentHashMap<>();
    private Long id = 0L;

    @Override
    public Map<Long, ResultModel> findAll() {
        return map;
    }

    @Override
    public void save(String inputEx, double result) {
        ResultModel myExpression = new ResultModel(++id, inputEx, result);
        map.put(id, myExpression);
    }
}
