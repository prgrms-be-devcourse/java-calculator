package com.devcourse.java.common;

import java.util.List;

public interface Storage<T> {
    void save(T type);
    List<T> fetchAll();
}
