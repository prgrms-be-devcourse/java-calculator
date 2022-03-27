package repository;

import java.util.List;

public interface calculatorRepository {
    void save(String exp, int result);
    List<String> getResults();
    void clear();
}
