package service;

import model.CalculationDto;

import java.util.List;

public interface CalculationService {
    List<String> findAll();
    CalculationDto calculate(String command);
}
