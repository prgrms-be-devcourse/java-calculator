package model.repository;

import model.entity.Calculator;

import java.util.List;

public interface CalculatorRepository {
    void save(Calculator calculator);

    List<Calculator> findAll();
}
