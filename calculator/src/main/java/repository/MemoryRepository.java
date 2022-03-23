package repository;

import entity.Expression;

import java.util.List;
import java.util.Optional;

public interface MemoryRepository {

    Expression save(String input, double result);
    List<Expression> findAll();

}
