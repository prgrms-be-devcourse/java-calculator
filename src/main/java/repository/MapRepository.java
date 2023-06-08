package main.java.repository;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static main.java.util.PrintOutMessage.EMPTY_MESSAGE;

public class MapRepository implements Repository {

    int historyCount;
    Map<Integer, String> mapRepository;
    public MapRepository() {
        this.mapRepository = new LinkedHashMap<>();
        this.historyCount = 0;
    }

    @Override
    public void saveHistory(String history) {
        this.mapRepository.put(historyCount, history);
        historyCount++;
    };

    @Override
    public void showHistory() {
        Iterator iter = mapRepository.values().iterator();
        if(!iter.hasNext())
            System.out.println(EMPTY_MESSAGE);
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
