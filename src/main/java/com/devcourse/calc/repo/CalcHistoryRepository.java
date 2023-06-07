package com.devcourse.calc.repo;

import com.devcourse.calc.model.History;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalcHistoryRepository {

    private final Map<Integer, History> histories = new HashMap<>();
    private int index = 0;

    public void saveHistory(History history) {
        histories.put(index++, history);
    }

    public List<History> getAllHistories() {
        return new ArrayList<>(histories.values());
    }
}
