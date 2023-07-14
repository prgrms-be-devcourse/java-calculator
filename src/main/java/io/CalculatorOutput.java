package io;

import model.entity.Calculator;
import model.vo.CalculationResult;

public interface CalculatorOutput {
    void printMenuMessage();

    void printSelectOtherMenu();

    void printExpression(CalculationResult expression);

    void printRecords(Calculator calculator);
}
