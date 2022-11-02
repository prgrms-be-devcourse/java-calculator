package com.programmers.calculator.repository;

import java.util.List;

public interface Repository<K, V> {

    V save(V entity);

    List<V> findAll();

    void deleteAll();

    List<V> findAllById();

}
