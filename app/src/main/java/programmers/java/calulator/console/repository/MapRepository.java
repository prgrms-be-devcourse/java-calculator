package programmers.java.calulator.console.repository;

import programmers.java.calulator.common.repository.History;
import programmers.java.calulator.common.repository.Repository;

import java.util.*;

public class MapRepository implements Repository {
    private final Map<Long, History> repository;
    private Long idCounter;
    private MapRepository() {
        this.repository = new HashMap<>();
        this.idCounter = 0L;
    }

    @Override
    public void save(History history) {
        repository.put(++idCounter, history);
    }

    @Override
    public List<History> findAll() {
        return repository.values()
                .stream()
                .toList();
    }


    private static class LazyHolder {
        private static final MapRepository INSTANCE = new MapRepository();
    }

    public static MapRepository getInstance() {
        return LazyHolder.INSTANCE;
    }
}


