package repository;

import entity.Data;

import java.util.List;

public interface CalculatorRepository {
    String save(Data data);

    Data findById(Long id);

    List<Data> findAll();

    void clear();
}
