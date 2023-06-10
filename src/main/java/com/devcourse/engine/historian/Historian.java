package com.devcourse.engine.historian;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Historian {

    private HashMap<Integer, String> history = new HashMap<>();
    private static int lastIndex = 0;

    public void saveHistory(List<String> expression, double result) {
        history.put(++ lastIndex, String.join(" ", expression) + " = " + result);
    }

    public String getHistory(int index) {
        if (index < 1)
            return "표시할 이력이 없습니다.";
        return "#" + index + ". " + history.get(index);
    }

    public int getLastIndex() {
        return lastIndex;
    }
}
