package org.programmers.repository;

import org.programmers.entity.ResultModel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CalculatorRepository implements Repository{
    private final Map<Long, ResultModel> map = new ConcurrentHashMap<>();

    @Override
    public Map<Long, ResultModel> findAll() {
        return map;
    }

    @Override
    public ResultModel save(ResultModel resultModel) {
       map.put(resultModel.getExpressionId(), resultModel);
       return resultModel;
    }
}
