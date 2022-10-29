package calculator.domain;

import java.util.List;

public interface Calculator {
    List<CalculationResultHistory> getAllData();
    String calculate(String expression);
}