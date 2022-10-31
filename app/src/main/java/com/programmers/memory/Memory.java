package com.programmers.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Memory {

  private final List<String> memory = new ArrayList<>();

  public void save(String calcForm) {
    memory.add(calcForm);
  }

  public List<String> findAll() {
    if (memory.isEmpty()) {
      throw new NoSuchElementException("저장된 내역이 없습니다");
    } else {
      return memory;
    }
  }
}
