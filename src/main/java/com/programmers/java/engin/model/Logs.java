package com.programmers.java.engin.model;


import java.util.ArrayList;
import java.util.List;

public class Logs {
    private List<String> logs = new ArrayList<>();

    public void add(String input, String output) {
        logs.add(input + " = " + output);
        if (logs.size() == 51){
            logs.remove(0);
        }
    }

    public List<String> getLogs(){
        return logs;
    }
}
