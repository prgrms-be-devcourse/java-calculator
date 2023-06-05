package programmers.java.calulator.console.repository;

import java.util.HashMap;
import java.util.Map;

public class MapRepository {
    private final Map<String, Integer> repository;

    private MapRepository() {
        this.repository = new HashMap<>();
    }

    public void add(String expression, int result) {
        repository.put(expression, result);
    }

    public Map<String, Integer> getRepository() {
        return repository;
    }

    private static class LazyHolder {
        private static final MapRepository INSTANCE = new MapRepository();
    }

    public static MapRepository getInstance() {
        return LazyHolder.INSTANCE;
    }
}


