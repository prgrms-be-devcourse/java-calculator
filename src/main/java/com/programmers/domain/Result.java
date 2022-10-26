package com.programmers.domain;

import java.util.Map;

public interface Result<K, V> {

    void addResult(K input, V result);

    public Map<K, V> getResult();
}
