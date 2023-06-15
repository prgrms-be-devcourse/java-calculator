package com.programmers.calculator;

import java.util.Map;

public interface Repository {
    Map<Long, CalcResult> findAll();

    Long save(CalcResult calcResult);

    int getSize();
}
