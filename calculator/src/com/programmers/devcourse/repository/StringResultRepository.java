package com.programmers.devcourse.repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class StringResultRepository implements ResultRepository<String, Double> {

  private final Map<String, Double> resultMap;

  public StringResultRepository() {
    this.resultMap = new LinkedHashMap<>();

  }


  @Override
  public void save(String expression, Double result) {
    resultMap.put(expression, result);
  }

  @Override
  public Map<String, Double> getAll() {
    return Map.copyOf(resultMap);
  }

  @Override
  public void forEach(BiConsumer<String, Double> biConsumer) {
    resultMap.forEach(biConsumer);
  }

  @Override
  public int getSize() {
    return this.resultMap.size();
  }
}
