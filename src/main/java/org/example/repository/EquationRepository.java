package org.example.repository;

public interface EquationRepository {
    void save(String equation, double resultNum);
    String[] findAll();
}
