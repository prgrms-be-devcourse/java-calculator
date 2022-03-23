package com.programmers.devcourse.repository;

import java.util.LinkedList;
import java.util.List;

public class StringResultRepository implements ResultRepository<String> {

  private List<String> resultList;

  public StringResultRepository() {
    this.resultList = new LinkedList<>();
  }

  public StringResultRepository(List<String> resultList) {

    this.resultList = resultList;
  }

  @Override
  public void save(String result) {
    resultList.add(result);
  }

  @Override
  public String[] getAllResults() {

    return resultList.toArray(new String[resultList.size()]);
  }

  @Override
  public int getSize() {
    return this.resultList.size();
  }
}
