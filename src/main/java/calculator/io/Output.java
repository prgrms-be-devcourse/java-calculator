package calculator.io;

import java.util.LinkedHashMap;

public interface Output {
    void putMenu();
    void showCalculationResult(LinkedHashMap<Integer, String> calculationResult);
    void inputError(String errorResponse);
}
