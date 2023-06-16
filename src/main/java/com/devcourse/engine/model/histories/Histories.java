package com.devcourse.engine.model.histories;

import java.util.HashMap;
import java.util.List;

public class Histories {

    private HashMap<Integer, List<String>> log = new HashMap<>();
    private int lastIndex = 0;

    public void saveHistory(List<String> expression, double result) {
        expression.add(String.valueOf(result));
        log.put(++ lastIndex, expression);
    }

    public List<String> getHistory(int index) {
        return log.get(index);
    }

    public int getLastIndex() {
        return lastIndex;
    }
}
