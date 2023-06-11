package com.programmers.java.calculator.search;

import com.programmers.java.repository.ResultRepository;

import java.util.ArrayList;

public class Searcher {
    private static ResultRepository resultRepository = new ResultRepository();

    public ArrayList<String> findAll() {
        return resultRepository.getCalculationResults();
    }
}