package org.programmers.repository;

import org.programmers.entity.ResultModel;

import java.util.Map;

public interface Repository {

    public Map<Long, ResultModel> findAll();

    public void save(String inputEx, double result);
}
