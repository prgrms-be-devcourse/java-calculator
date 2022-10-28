package com.project.java.engine.solver;

import com.project.java.engine.data.ResultFormat;
import com.project.java.exception.ContinuousOperatorException;
import com.project.java.exception.ZeroDivisionException;

import java.util.List;

public interface Solver {
    ResultFormat calculate(String expression) throws ZeroDivisionException, ContinuousOperatorException;
    String convertExpression(List<String> expression);

    int getPriority(String oper);
}
