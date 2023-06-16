package com.devcourse.engine.model.histories;

import java.util.HashMap;
import java.util.List;

public class Histories {

    private HashMap<Integer, String> log = new HashMap<>();
    private int lastIndex = 0;

    public void saveHistory(List<String> expression, double result) {
        log.put(++ lastIndex, String.join(" ", expression) + " = " + result);
    }

    public String getHistory(int index) {
        return "#" + index + ". " + log.get(index);
    }

    public int getLastIndex() {
        return lastIndex;
    }
}
