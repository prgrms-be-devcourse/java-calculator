package com.programmers.java.engin.model;


import java.util.ArrayList;
import java.util.List;

public class Logs {
    List<String> logs = new ArrayList<>();

    public void add(String log) {
        logs.add(log);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
