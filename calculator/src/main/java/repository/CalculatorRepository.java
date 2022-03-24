package repository;

import entity.Expression;

import java.util.List;

public interface CalculatorRepository {

    Expression save(String input, double result);
    List<Expression> findAll();

}
