package com.programmers.engine.model;

import com.programmers.engine.io.Output;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataBase {
    private final Map<Integer, Log> logs = new LinkedHashMap<>();

    public void showAll(Output output) {
        if (logs.isEmpty())
            output.dbNoDate();
        else {
            logs.forEach((order, log) -> log.show());
        }
    }
    public void addData(String s, BigDecimal result){
        logs.put(logs.size(), new Log(s, result));
    }
}
