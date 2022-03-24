package org.programmers.repository;

import org.programmers.entity.ResultModel;

import java.util.*;

public class CalculatorRepository implements Repository{
    Map<Long, ResultModel> map = new LinkedHashMap<>();
    Long id = 0L;
    @Override
    public List<ResultModel> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(String inputEx, double result) {
        ResultModel myExpression = new ResultModel(++id, inputEx, result);
        map.put(id, myExpression);
    }
}
