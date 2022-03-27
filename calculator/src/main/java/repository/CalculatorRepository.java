package repository;

import java.util.List;

public interface CalculatorRepository {
    void save(String exp, int result);
    int getResult(String exp);
    List<String> getResults();
    void clear();
}
