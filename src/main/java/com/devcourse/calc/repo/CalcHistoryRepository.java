package com.devcourse.calc.repo;

import com.devcourse.calc.model.History;

import java.util.HashMap;
import java.util.Map;

public class CalcHistoryRepository {

    private final Map<Integer, History> histories = new HashMap<>();
    private int index = 0;

    public void saveHistory(History history) {
        histories.put(index++, history);
    }

    public String getAllHistories() {
        StringBuilder result = new StringBuilder();
        for (History history : histories.values()) {
            result.append(history.toString());
        }
        return result.toString();
    }
}
