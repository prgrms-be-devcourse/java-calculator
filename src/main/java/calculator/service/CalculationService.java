package calculator.service;

import calculator.engine.model.CalculationDto;

import java.util.List;

public interface CalculationService {
    List<String> findAll();
    CalculationDto calculate(String command);
}
