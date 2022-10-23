package com.project.java.engine.solver;

import com.project.java.exception.ZeroDivisionException;

import java.util.List;
import java.util.Map;

public interface Solver {
    Map<Integer, List<String>> calculate(String expression) throws ZeroDivisionException;
}
