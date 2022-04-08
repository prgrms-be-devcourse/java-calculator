package com.caculator.io;

import com.caculator.dto.Result;

import java.util.List;

public interface Output {
    void printHistory(List<Result> history);

    void printError(String errMsg);

    void printResult(long result);
}
