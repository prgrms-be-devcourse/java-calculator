package com.devcourse.java.domain.Result;

import com.devcourse.java.common.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultStorage implements Storage<Result> {
    private static final Map<Integer, Result> storage = new HashMap<>();
    private int id = 1;

    @Override
    public void save(Result result) {
        storage.put(id, result);
        increaseId();
    }

    @Override
    public List<Result> fetchAll() {
        return new ArrayList<>(storage.values());
    }

    private void increaseId() {
        this.id += 1;
    }
}
