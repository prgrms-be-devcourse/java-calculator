package com.kimhunki.java.calculator.strategy;

import com.kimhunki.java.calculator.db.MemoryResultRepository;

import java.util.List;

public interface CalculatorStrategy {


    String calculate(List<String> expressionList);
}
