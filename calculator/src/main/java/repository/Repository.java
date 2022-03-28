package repository;

import java.util.List;
import java.util.stream.Collectors;

public interface Repository {
    void save(String exp, double result);

    String getResult(Long id);

    List<String> getResults();

    void clear();
}
