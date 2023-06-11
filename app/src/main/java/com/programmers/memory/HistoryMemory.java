package com.programmers.memory;

import java.util.*;

public class HistoryMemory {
    private Map<Integer, String> historyMemoryMap;
    private int orderNumber;

    public HistoryMemory() {
        this.historyMemoryMap = new HashMap<>();
        this.orderNumber = 0;
    }
}