package com.programmers.memory;

import java.util.*;

public class HistoryMemory {
    private Map<Integer, String> historyMemoryMap;
    private int orderNumber;

    public HistoryMemory() {
        this.historyMemoryMap = new HashMap<>();
        this.orderNumber = 0;
    }

    /**
     * 사용자가 입력한 중위 표현식을 저장하는 메소드
     *
     * @param inputExpression 사용자가 입력한 중위 표현식
     * @param result 계산 결과
     */
    public void saveHistory(String inputExpression, double result) {
        String formatExpression = String.format("%s = %.2f", inputExpression, result);
        historyMemoryMap.put(++orderNumber, formatExpression);
    }
}