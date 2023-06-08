package org.example.history;

import java.util.LinkedHashMap;
import java.util.Map;

public class History {

  private Map<Long, Formula> map = new LinkedHashMap<>();
  private long number = 0L;

  public void save(Formula formula) {
    map.put(++number, formula);
  }

  public void view() {
    for (Long key : map.keySet()) {
      Formula formula = map.get(key);
      System.out.println(key + " : " + formula);
    }
  }
}