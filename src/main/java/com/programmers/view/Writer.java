package com.programmers.view;

import com.programmers.model.CalculationResult;

import java.util.List;

public class Writer implements Output {

    @Override
    public void print(String message) {
        System.out.println(message);
        System.out.println();
    }

    @Override
    public void print(long result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void print(List<CalculationResult> record) {
        record.forEach(System.out::println);
        System.out.println();
    }
}
