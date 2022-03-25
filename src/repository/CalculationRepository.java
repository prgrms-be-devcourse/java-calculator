package repository;

import model.CalculationDto;

import java.util.List;

public interface CalculationRepository {
    void save(CalculationDto calculationDto);
    List<String> findAll();
}
