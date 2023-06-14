package com.programmers.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class History {

  private final Map<Integer, String> history = new HashMap<>();
  AtomicInteger index = new AtomicInteger();

  public void save(String formula, double answer) {
    history.put(index.addAndGet(1), formula + " = " + answer);
  }

  public void showHistory() {
    for (int key : history.keySet()) {
      String formula = history.get(key);
      System.out.println(formula);
    }
    System.out.println();
  }
}
