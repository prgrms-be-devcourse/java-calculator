package com.programmers.devcourse.repository;

import java.util.Map;

public interface ResultRepository<K, V> {

  void save(K expression, V result);

  Map<K, V> getAllResults();

  int getSize();
}
