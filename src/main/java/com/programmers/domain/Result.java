package com.programmers.domain;

import java.util.Map;

public interface Result<K, V> {

    void addResult(String problem, int answer);

    Map<K, V> getResult();
}
