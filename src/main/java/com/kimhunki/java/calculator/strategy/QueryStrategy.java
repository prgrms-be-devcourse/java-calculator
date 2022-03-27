package com.kimhunki.java.calculator.strategy;

import com.kimhunki.java.calculator.db.ResultRepository;

public interface QueryStrategy
{

    void printResult(ResultRepository resultRepository);
}
