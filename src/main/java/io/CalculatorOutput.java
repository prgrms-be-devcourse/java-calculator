package io;

import model.vo.CalculationResult;

public interface CalculatorOutput {
    void printMenuMessage();

    void printExpression(CalculationResult expression);

    void printRecords(String record, int result);
}
