package com.programmers.model;

import java.util.HashMap;
import java.util.Map;

public class History {

  private final Map<Integer, String> history = new HashMap<>();
  private int index = 0;

  public void save(String formula, double answer) {
    history.put(++index, formula + " = " + answer);
  }

  public void showHistory() {
    for (int key : history.keySet()) {
      String formula = history.get(key);
      System.out.println(formula);
    }
  }
}
