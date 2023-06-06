package org.example.history;

import java.util.LinkedHashMap;
import java.util.Map;

public class History {

  private Map<Long, String> map = new LinkedHashMap<>();
  private long number = 0L;

  public void save(String formula) {
    map.put(++number, formula);
  }

  public Map<Long, String> findAll() {
    return map;
  }
}