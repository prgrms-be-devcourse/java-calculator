package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class History {
    private List<String> log = new ArrayList<>();

    public List<String> getHistory() {
        return log;
    }

    public void addHistory(String inputString,int result){
        StringBuilder sb = new StringBuilder();
        log.add(sb.append(inputString).append(" = ").append(result).toString());
    }
}
