package com.programmers.devcourse.repository;

import java.util.Hashtable;
import java.util.Map;

public class StringResultRepository implements ResultRepository<String, Double> {

  private final Map<String, Double> resultMap;

  public StringResultRepository() {
    this.resultMap = new Hashtable<>();
  }

  public StringResultRepository(Map<String, Double> resultMap) {

    this.resultMap = resultMap;
  }


  @Override
  public void save(String expression, Double result) {
    resultMap.put(expression, result);
  }

  @Override
  public Map<String, Double> getAllResults() {
    return Map.copyOf(resultMap);
  }

  @Override
  public int getSize() {
    return this.resultMap.size();
  }
}
