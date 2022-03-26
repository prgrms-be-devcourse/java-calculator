package calculator.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryResultRepository implements ResultRepository {

    private static final Map<Long, String> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(String result) {
        store.put(++sequence, result);
    }

    @Override
    public Optional<List<String>> findAll() {
        if (store.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new ArrayList<>(store.values()));
    }

    public void clearStore() {
        store.clear();
    }
}
