package repository;

import java.util.List;

public interface CalculatorRepository {
    void save(String exp, double result);

    double getResult(String exp);

    List<String> getResults();

    void clear();
}
