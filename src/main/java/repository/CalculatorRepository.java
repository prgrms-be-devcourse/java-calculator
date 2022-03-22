package repository;

import java.util.List;

public interface CalculatorRepository {

    void save(String expression);
    List<String> findAll();
}
