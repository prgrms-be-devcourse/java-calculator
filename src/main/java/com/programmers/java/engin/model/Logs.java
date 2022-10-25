package com.programmers.java.engin.model;


import java.util.ArrayList;
import java.util.List;

public class Logs {
    List<String> logs = new ArrayList<>();

    public void add(String log) { // 최대 50개 까지 저장
        logs.add(log);
        if (logs.size() == 51){
            logs.remove(0);
        }
    }

    @Override
    public String toString() {
        if (logs.size() == 0) return "\n";
        return "\n" + String.join("\n",logs) + "\n";
    }
}
