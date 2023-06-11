package calculator.io;

import calculator.model.CalculationResult;

import java.util.List;

public interface Output {
    void putMenu();
    void showCalculationResult(List<CalculationResult> calcResults);
    void inputError(String errorResponse);
    void showResult(String calculationResult);
}
