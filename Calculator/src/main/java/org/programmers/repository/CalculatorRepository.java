package org.programmers.repository;

import org.programmers.entity.ResultModel;

import java.util.*;

public class CalculatorRepository implements Repository{
    private Map<Long, ResultModel> map = new LinkedHashMap<>();
    private Long id = 0L;

    @Override
    public List<ResultModel> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void save(String inputEx, double result) {
        ResultModel myExpression = new ResultModel(++id, inputEx, result);
        map.put(id, myExpression);
    }
}
