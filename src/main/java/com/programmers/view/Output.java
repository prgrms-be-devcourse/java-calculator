package com.programmers.view;

import com.programmers.model.CalculationResult;

import java.util.List;

public interface Output {
    void printRecord(List<CalculationResult> record);

    void printMessage(String errorMsg);

    void printResult(long result);

}
