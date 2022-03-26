package calculator.repository;

import java.util.List;
import java.util.Optional;

public interface ResultRepository {
    void save(String result);

    Optional<List<String>> findAll();
}
