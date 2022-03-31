package main.calculator.engine.model;

import java.util.List;

public interface CalculationRepository {
    void save(String content, String result);
    List<String> findAll();
}
