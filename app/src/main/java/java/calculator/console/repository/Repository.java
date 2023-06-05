package java.calculator.console.repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private final Map<String, Integer> repository;

    private Repository() {
        this.repository = new HashMap<>();
    }

    public void add(String expression, int result) {
        repository.put(expression, result);
    }

    public Map<String, Integer> getRepository() {
        return repository;
    }

    private static class LazyHolder {
        private static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        return LazyHolder.INSTANCE;
    }
}


