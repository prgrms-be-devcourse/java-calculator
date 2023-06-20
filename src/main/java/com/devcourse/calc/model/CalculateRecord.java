package com.devcourse.calc.model;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class CalculateRecord extends Result{

    private final List<History> histories;

    public CalculateRecord(List<History> histories) {
        super();
        this.histories = histories;
    }

    @Override
    public String toString() {
        return histories.stream()
                .map(String::valueOf)
                .collect(joining("\n"));
    }
}
