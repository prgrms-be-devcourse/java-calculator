package model.repository;

import model.entity.Calculator;
import model.vo.CalculationResult;
import model.vo.Expression;

import java.util.List;

public class MemoryCalculatorRepository implements CalculatorRepository {
    @Override
    public void save(Expression expression, CalculationResult calculationResult) {

    }

    @Override
    public List<Calculator> findAll() {
        return null;
    }
}
