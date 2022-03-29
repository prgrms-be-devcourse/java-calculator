package com.programmers.oop.repository;

import java.util.List;

public interface ComputeHistoryRepository<ResultType> {
    ResultType save(String calculation);

    List<ResultType> findAll();

}
