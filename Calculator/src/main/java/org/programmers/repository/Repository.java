package org.programmers.repository;

import org.programmers.entity.ResultModel;

import java.util.List;

public interface Repository {
    public List<ResultModel> findAll();
    public void save(String inputEx, double result);
}
