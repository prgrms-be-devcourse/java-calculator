package main.java.repository;

import main.java.domain.History;

import java.util.*;

public class MapRepository implements HistoryRepository {

    private int historyCount;
    private Map<Integer, History> mapRepository;
    public MapRepository() {
        this.mapRepository = new LinkedHashMap<>();
        this.historyCount = 0;
    }

    @Override
    public void saveHistory(History history) {
        this.mapRepository.put(historyCount, history);
        historyCount++;
    };

    @Override
    public List<History> getAllHistoryToList() {
        return new ArrayList<>(mapRepository.values());
    }
}
