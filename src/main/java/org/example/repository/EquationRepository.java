package org.example.repository;

import java.util.List;

public interface EquationRepository {
    void save(String equation, double resultNum);
    List<String> findAll();
}
