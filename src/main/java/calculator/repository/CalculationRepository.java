package calculator.repository;

import calculator.engine.model.CalculationDto;

import java.util.List;

public interface CalculationRepository {
    void save(CalculationDto calculationDto);
    List<String> findAll();
}
