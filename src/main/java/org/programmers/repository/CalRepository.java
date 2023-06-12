package org.programmers.repository;

import java.util.Map;

public interface CalRepository {
    void save(String formula, String result);
    Map<Long, String> getQueryList();


}
