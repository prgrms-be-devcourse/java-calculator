package com.programmers.view;

import com.programmers.core.data.CalculationResult;

import java.util.List;

public interface Output {

    void print(String message);

    void print(long result);

    void print(List<CalculationResult> record);

}
