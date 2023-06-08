package model;

import java.util.ArrayList;
import java.util.List;

public class History {
    static List<String> log = new ArrayList<>();
    public boolean isEmpty() {
        return log.isEmpty();
    }

    public void getHistory() {
        for (String s : log) {
            System.out.println(s);
        }
    }

    public Integer getHistoryLen() {
        return log.size();
    }

    public void addHistory(String result){
        log.add(result);
    }
}
