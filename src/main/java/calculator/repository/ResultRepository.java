package calculator.repository;

import java.util.List;

public interface ResultRepository {
    void save(String result);

    List<String> findAll();
}
