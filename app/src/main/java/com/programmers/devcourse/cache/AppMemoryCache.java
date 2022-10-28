package com.programmers.devcourse.cache;

import java.util.ArrayList;
import java.util.List;

public class AppMemoryCache implements AppCache {
    private ArrayList<String> cacheList = new ArrayList<>();

    private AppMemoryCache() {
    }

    private static class LazyHolder {
        private static final AppMemoryCache INSTANCE = new AppMemoryCache();
    }

    public static AppMemoryCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void save(String expression) {
        cacheList.add(expression);
    }

    @Override
    public List<String> getAll() {
        return cacheList;
    }
}
