package main.java.repository;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static main.java.view.ConsoleOutput.EMPTY_MESSAGE;

public class MapRepository implements Repository {

    Map<Integer, String> mapRepository;
    public MapRepository() {
        this.mapRepository = new LinkedHashMap<>();
    }

    @Override
    public void saveHistory(String history) {
        this.mapRepository.put(1, history);
    };

    @Override
    public void showHistory() {
        Iterator iter = mapRepository.values().iterator();
        if(!iter.hasNext())
            System.out.println(EMPTY_MESSAGE);
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    };
}
