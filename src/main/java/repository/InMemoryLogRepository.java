package repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryLogRepository<T> implements LogRepository {
    private final Map<Long, T> memory = new LinkedHashMap<>();
    private static Long sequence = 0L;

    public InMemoryLogRepository() {
    }

    @Override
    public void save(Object log) {
        memory.put(sequence++, (T) log);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(memory.values());
    }

}
