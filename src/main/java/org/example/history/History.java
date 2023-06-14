package org.example.history;

import java.util.LinkedHashMap;
import java.util.Map;

public class History {
  private Map<Long, Formula> memory = new LinkedHashMap<>();
  private long number = 0L;

  public void save(Formula formula) {
    memory.put(++number, formula);
  }

  public void view() {
    for (Long key : memory.keySet()) {
      Formula formula = memory.get(key);
      System.out.println(key + " : " + formula);
    }
  }
}
