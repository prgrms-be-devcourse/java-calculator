package repository;

import domain.CalculationDto;

import java.util.List;

public interface CalculationRepository {
    void save(CalculationDto calculationDto);
    List<String> findAll();
}
