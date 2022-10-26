package com.programmers.calculator.view;

import com.programmers.calculator.domain.OperationResult;

public interface Output {
    void printString(String str);
    void printlnString(String str);
    void printNoHistory();
    void printHistory(OperationResult operationResult);
}
