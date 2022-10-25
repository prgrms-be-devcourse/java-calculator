package com.programmers.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryImpl implements Repository {

  private final List<String> memory = new ArrayList<>();
  private final Map<String, String> cache = new HashMap<>();

  public void save(String form, String answer) {
    cache.put(form, answer);
    memory.add(form + " = " + answer);
  }

  public List<String> findAll() {
    return memory;
  }

  public String getValue(String key) {
    return cache.get(key);
  }

  public boolean find(String key) {
    return cache.containsKey(key);
  }

}
