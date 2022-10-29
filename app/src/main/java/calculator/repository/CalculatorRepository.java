package calculator.repository;

import calculator.domain.CalculationResult;

import java.util.List;
import java.util.Optional;

public interface CalculatorRepository {
    void save(CalculationResult result);
    List<String> getAll();
    Optional<String> getResultFromExpression(String expression);
}
