package service;

import java.util.List;

public interface CalculationService {
    List<String> findAll();
    void calculate(String command);
}
