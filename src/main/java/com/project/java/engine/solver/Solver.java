package com.project.java.engine.solver;

import com.project.java.exception.ZeroDivisionException;

import java.util.List;
import java.util.Map;

public interface Solver {
    Map<String, Double> calculate(String expression) throws ZeroDivisionException;
}
