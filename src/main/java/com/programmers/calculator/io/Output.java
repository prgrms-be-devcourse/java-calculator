package com.programmers.calculator.io;

import com.programmers.calculator.model.CalcData;

import java.util.List;

public interface Output {
    void select();

    void result(double i);

    void results(List<CalcData> list);

    void error(String s);
}
