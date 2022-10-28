package com.programmers.repository;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class MemoryRepository implements HistoryRepository {
    final StringBuffer sb = new StringBuffer();
    //    private List<String> logs = new ArrayList<>();
    private Map<Timestamp, String> logs = new TreeMap<>();

    @Override
    public Collection<String> readData() {
         return logs.values();
    }

    @Override
    public String printData() {
        Collection<String> allRecord =readData();
        if(allRecord.isEmpty()){
            return "저장된 데이터가 없습니다.";
        }
        String logsString = sb.toString();
        return logsString;
    }

    @Override
    public void addData(String data) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        logs.put(timestamp, data);
        sb.append(data);
        sb.append("\n");
    }

}
