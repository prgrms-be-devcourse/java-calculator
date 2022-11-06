package calculator.repository;

import calculator.dto.Calculation;

import java.util.List;

public interface CalculateRepository {

    void save(Calculation calculation);

    List<Calculation> findAll();
}
