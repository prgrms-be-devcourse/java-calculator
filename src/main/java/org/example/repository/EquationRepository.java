package org.example.repository;

public interface EquationRepository {
    void save(String str);
    String[] findAll();
}
