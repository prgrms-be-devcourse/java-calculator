package com.programmers.calculator.repository;

import com.programmers.calculator.model.CalcData;

import java.util.List;

public interface Repository {
    List<CalcData> getAll();

    void save(CalcData c);
}
