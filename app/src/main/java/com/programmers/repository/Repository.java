package com.programmers.repository;

import java.util.List;

public interface Repository {

  void save(String str1, String str2);

  List<String> findAll();

  String getValue(String str);

  boolean find(String str);
}
