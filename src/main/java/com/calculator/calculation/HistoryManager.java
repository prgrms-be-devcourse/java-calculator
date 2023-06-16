package com.calculator.calculation;

import java.util.HashMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class HistoryManager {
    private HashMap<String, Integer> historyStorage = new HashMap<>();

    public void printHistory(){
        for(HashMap.Entry<String, Integer> entry : historyStorage.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+" = "+value);
        }
    }

    public void addHistory(String expression, int result){
        historyStorage.put(expression, result);

    }

}
