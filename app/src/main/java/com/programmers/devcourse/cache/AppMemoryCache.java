package com.programmers.devcourse.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AppMemoryCache implements AppCache {
    private final Map<Integer, String> map = new LinkedHashMap<>();
    int index;
    private AppMemoryCache() {
        this.index = 0;
    }

    private static class LazyHolder {
        private static final AppMemoryCache INSTANCE = new AppMemoryCache();
    }

    public static AppMemoryCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void save(String expression) {
        map.put(index++,expression);
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(map.values());
    }
}
