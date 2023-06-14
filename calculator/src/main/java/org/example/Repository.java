package org.example;

import java.util.List;

public interface Repository {
    void save(String expression, int result);
    List<String> getRecords();
}
