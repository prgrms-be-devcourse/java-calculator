package model.repository;

import model.entity.Calculator;
import model.vo.CalculationResult;
import model.vo.Expression;

import java.util.List;

public interface CalculatorRepository {
    void save(Expression expression, CalculationResult calculationResult);

    List<Calculator> findAll();
}
