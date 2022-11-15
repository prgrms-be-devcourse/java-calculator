package com.programmers.java.engin.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LogGroups {
    private final List<Log> logs;

    public LogGroups(List<Log> logs) {
        this.logs = logs;
    }

    public void insertLog(Log log){
        logs.add(log);
    }
    public int getLogsCount(){
        return logs.size();
    }

    public List<Log> getAllLogs(){
        return List.copyOf(logs);
    }
}
