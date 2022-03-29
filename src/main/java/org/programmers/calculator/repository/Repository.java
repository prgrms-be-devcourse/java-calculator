package org.programmers.calculator.repository;

import org.programmers.calculator.configuration.Component;

import java.util.List;

@Component
public interface Repository {

    public void save(String expression, String result);
    public String findPrevious();
    public String findByKey(String expression);
    public List<String> printAll();
}
