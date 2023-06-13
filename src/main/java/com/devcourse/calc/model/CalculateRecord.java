package com.devcourse.calc.model;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class CalculateRecord {

    private final List<History> histories;

    public CalculateRecord(List<History> histories) {
        this.histories = histories;
    }

    @Override
    public String toString() {
        String result = histories.stream()
                .map(String::valueOf)
                .collect(joining());
        return result.substring(0, result.length() - 1);
    }
}