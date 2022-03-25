package org.programmers.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResultModel {
    Long id;
    String inputEx;
    double result;

    @Override
    public String toString() {
        return inputEx + " = " + result;
    }
}
