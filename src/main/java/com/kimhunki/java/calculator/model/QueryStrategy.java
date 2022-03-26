package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.db.ResultRepository;

public interface QueryStrategy
{

    void printResult(ResultRepository resultRepository);
}
