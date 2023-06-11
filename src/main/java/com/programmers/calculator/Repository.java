package com.programmers.calculator;

public interface Repository {
    String findAll();

    void save(CalcResult calcResult);

    int getSize();
}
