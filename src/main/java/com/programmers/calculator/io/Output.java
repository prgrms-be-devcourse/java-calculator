package com.programmers.calculator.io;

import com.programmers.calculator.model.CalcData;

import java.util.List;

public interface Output {
    void select();

    void showArithmeticResult(double arithmeticResult);

    void showArithmeticResults(List<CalcData> list);

    void error(String errorMsg);
}
