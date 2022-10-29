package calculator.repository;

import calculator.domain.CalculationResultHistory;

import java.util.List;
import java.util.Optional;

public interface CalculatorRepository {
    void save(CalculationResultHistory result);
    List<String> getAll();
    Optional<String> getResultFromExpression(String expression);
}
