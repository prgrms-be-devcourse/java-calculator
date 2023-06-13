package calculator.io;

import calculator.model.CalculationResult;

import java.util.Map;

public interface Output {
    void putMenu();
    void showCalculationResult(Map<Integer, CalculationResult> result);
    void inputError(String errorResponse);
    void showResult(String calculationResult);
}
