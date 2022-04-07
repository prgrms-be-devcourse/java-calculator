package com.programmers.java.repository;


import com.programmers.java.entity.Calculation;

import java.util.List;

public interface Repository {

    void save(Calculation calculation);

    List<Calculation> findAll();

    void clearStore();
}