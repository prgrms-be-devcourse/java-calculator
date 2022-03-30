package com.programmers.java.service;

import com.programmers.java.entity.Calculation;

import java.util.List;

public interface HistoryService {

    void save(String formula, int result);

    List<Calculation> findHistory();

}
