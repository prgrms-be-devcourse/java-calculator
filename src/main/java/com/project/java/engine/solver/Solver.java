package com.project.java.engine.solver;

import com.project.java.engine.data.ResultFormat;
import com.project.java.exception.ZeroDivisionException;

public interface Solver {
    ResultFormat calculate(String expression) throws ZeroDivisionException;

    int getPriority(String oper);
}
