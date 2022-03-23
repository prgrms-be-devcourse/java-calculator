package com.programmers.java.calculation.parse;

public interface Validation {

    boolean validateContOp(String input);

    boolean validateFirstOp(String input);

    boolean validateLastOp(String input);

    boolean validateString(String input);

}
