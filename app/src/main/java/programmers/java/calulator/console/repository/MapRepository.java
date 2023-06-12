package programmers.java.calulator.console.repository;

import programmers.java.calulator.common.repository.History;
import programmers.java.calulator.common.repository.Repository;

import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MapRepository implements Repository {
    private final Map<Long, History> repository;
    private AtomicLong idCounter;

    private MapRepository() {
        this.repository = new ConcurrentHashMap<>();
        this.idCounter = new AtomicLong(0);
    }

    @Override
    public void save(History history) {
        repository.put(idCounter.incrementAndGet(), history);
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


