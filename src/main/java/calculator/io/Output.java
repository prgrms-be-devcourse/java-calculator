package calculator.io;

import java.util.List;

public interface Output {
    void putMenu();
    void showCalculationResult(List<String> calcResults);
    void inputError(String errorResponse);
    void showResult(Integer calculationResult);
}
