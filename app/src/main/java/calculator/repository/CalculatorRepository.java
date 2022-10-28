package calculator.repository;

import calculator.domain.CalculationResult;

import java.util.List;

public interface CalculatorRepository {
    void save(CalculationResult result);
    List<String> getAll();
}
