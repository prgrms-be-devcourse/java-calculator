package com.programmers.java.engine.repository;

public interface CacheMemory {
    boolean isCacheExit(String formula);

    long cache(String s);
}
