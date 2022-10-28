package com.programmers.engine.model;

import com.programmers.engine.io.Output;

import java.util.LinkedList;

public class DataBase {
    private final LinkedList<String> data = new LinkedList<>();
    public void showAll(Output output) {
        if (data.isEmpty()) output.dbNoDate();
        else                output.showAll(data);
    }
    public void addData(String s){data.add(s);}
}
