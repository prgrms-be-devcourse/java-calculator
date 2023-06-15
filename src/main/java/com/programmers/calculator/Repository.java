package com.programmers.calculator;

public interface Repository {
    String findAll();

    Long save(CalcResult calcResult);

    int getSize();
}
