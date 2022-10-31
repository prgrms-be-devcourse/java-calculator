package com.programmers.domain;

import java.util.Map;

public interface Result<K, V> {

    void addResult(V result);

    Map<K, V> getResult();
}
