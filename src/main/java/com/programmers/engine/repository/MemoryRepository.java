package com.programmers.engine.repository;

import java.sql.Timestamp;
import java.util.*;

public class MemoryRepository implements HistoryRepository {
    final StringBuffer sb = new StringBuffer();
//    private List<String> logs = new ArrayList<>();
    private Map<Timestamp,String> logs = new TreeMap<>();

    @Override
    public Collection<String> readData() {
         return logs.values();
    }

    @Override
    public String printData() {
        String logsString = sb.toString();
        return logsString;
    }

    @Override
    public void addData(String data) {
//        logs.add(data);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        logs.put(timestamp,data);
        sb.append(data);
        sb.append("\n");
    }

}
