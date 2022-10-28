package calculator.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class HistoryImpl implements History{
    private Map<String, String> map;

    public HistoryImpl() {
        this.map = new LinkedHashMap<>();
    }

    @Override
    public void getHistory(String key) {
        System.out.println(map.get(key));
    }

    @Override
    public void historyList() {
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }

    @Override
    public void addHistory(String key, String value) { map.put(key, value); }

    @Override
    public boolean isContainsKey(String key) {
        if(map.containsKey(key))    {
            getHistory(key);
            return true;
        }
        return false;
    }
}
