package com.devcourse.java.domain.storage;

import java.util.List;

public interface Storage<T> {
    void save(T type);
    List<T> fetchAll();
}
