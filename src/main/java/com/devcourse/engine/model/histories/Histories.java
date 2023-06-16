package com.devcourse.engine.model.histories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Histories {

    private HashMap<Integer, List<String>> log = new HashMap<>();
    private int lastIndex = 0;

    public void saveHistory(List<String> expressions, double result) {
        ArrayList<String> allExpressions = new ArrayList<>(expressions);
        allExpressions.add(String.valueOf(result));
        log.put(++lastIndex, allExpressions);
    }

    public List<String> getHistory(int index) {
        return log.get(index);
    }

    public int getLastIndex() {
        return lastIndex;
    }
}
