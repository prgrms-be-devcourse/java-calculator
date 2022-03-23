package com.programmers.devcourse.repository;

public interface ResultRepository<T> {

  void save(T result);

  T[] getAllResults();

  int getSize();
}
