package com.prgrms.ndy.domain.operation;

public class Addition implements Operation {
    @Override
    public double calc(double a, double b) {
        return a + b;
    }
}
