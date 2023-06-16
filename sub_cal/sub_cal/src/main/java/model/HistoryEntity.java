package model;

import java.util.ArrayList;
import java.util.List;


public class HistoryEntity {
    private List<String> log = new ArrayList<>();

    public List<String> getHistory() {
        return log;
    }

    public void addHistory(String expression,int result){
        StringBuilder sb = new StringBuilder();
        log.add(sb.append(expression).append(" = ").append(result).toString());
    }
}
