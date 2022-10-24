package com.programmers.engine.repository;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepository implements Repository {
    final StringBuffer sb = new StringBuffer();
    private List<String> logs = new ArrayList<>();

    @Override
    public String getData() {
        String logsString = sb.toString();
        return logsString;
    }

    @Override
    public void addData(String data) {
        logs.add(data);
        sb.append(data);
        sb.append("\n");
    }

}
