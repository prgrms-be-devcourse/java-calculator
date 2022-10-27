package com.programmers.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memory {

  private final List<String> memory = new ArrayList<>();
  private final Map<String, Double> cache = new HashMap<>();

  public void cacheSave(String form, Double answer) {
    cache.put(form, answer);
  }

  public Double cacheFind(String form) {
    return cache.get(form);
  }

  public boolean contains(String form) {
    return cache.containsKey(form);
  }

  public void save(String calcForm) {
    memory.add(calcForm);
  }

  public void findAll() {
    memory.forEach(System.out::println);
  }
}
