package org.devcourse.repository;

import java.util.List;

public interface Repository {

    String findLatestHistory();
    List<String> findAll();
    void save(String runHistory);

}
