package org.programmers.calculator.repository;

import java.util.List;

public interface Repository {

    void save(String expression, String result);
    String findPrevious();
    String findByKey(String expression);
    List<String> printAll();
}
