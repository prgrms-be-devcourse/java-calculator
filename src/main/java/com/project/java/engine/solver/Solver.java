package com.project.java.engine.solver;

import com.project.java.exception.ZeroDivisionException;

public interface Solver {
    int calculate(String expression) throws ZeroDivisionException;
}
