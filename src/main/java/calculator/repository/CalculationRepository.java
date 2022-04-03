package calculator.repository;

import java.util.List;

public interface CalculationRepository {
    String save(String command, Double result);
    List<String> findAll();
}
