package repository;

import java.util.List;

public interface ExpressionRepository {

    void save(String expression);
    List<String> findAll();
}
