package com.programmers.devcourse.cache;

import java.util.List;

public interface AppCache {
    void save(String expression);
    List<String> getAll();
}
