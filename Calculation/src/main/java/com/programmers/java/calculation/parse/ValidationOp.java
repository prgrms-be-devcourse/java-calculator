package com.programmers.java.calculation.parse;

public interface ValidationOp {

    boolean validate(String[] input);

    boolean validateFirstAndLastOp(String[] input);
}
