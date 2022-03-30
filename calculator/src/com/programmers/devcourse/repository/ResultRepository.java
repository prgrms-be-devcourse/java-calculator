package com.programmers.devcourse.repository;

import java.util.Map;
import java.util.function.BiConsumer;

public interface ResultRepository<K, V> {

  void save(K expression, V result);

  Map<K, V> getAll();

  void forEach(BiConsumer<K, V> biConsumer);

  int getSize();
}
