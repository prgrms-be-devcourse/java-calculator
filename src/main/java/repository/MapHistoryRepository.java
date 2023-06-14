package main.java.repository;

import main.java.domain.History;

import java.util.*;

public class MapHistoryRepository implements HistoryRepository {

    private int historyCount;
    private Map<Integer, History> MapHistoryRepository;
    public MapHistoryRepository() {
        this.MapHistoryRepository = new LinkedHashMap<>();
        this.historyCount = 0;
    }

    @Override
    public void saveHistory(History history) {
        this.MapHistoryRepository.put(historyCount, history);
        historyCount++;
    }

    @Override
    public List<History> getAllHistoryToList() {
        return new ArrayList<>(MapHistoryRepository.values());
    }

}
