package org.programmers.repository;

import lombok.Getter;
import org.programmers.entity.ResultModel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * save 함수가 엔티티를 직접 파라미터로 받아 저장하도록 수정했습니다.
 */
@Getter
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
