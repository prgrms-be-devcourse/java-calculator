package repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryRepository implements Repository{
    private final Map<Long, String> db = new LinkedHashMap<>();
    private Long id = 0L;

    @Override
    public void save(String exp, double result) {
        db.put(++id, exp + " = " + result);
    }
    @Override
    public String getResult(Long id) {
        return db.get(id);
    }
    @Override
    public List<String> getResults() {
        return db.entrySet()
                .stream()
                .map(e -> e.getKey() + "번 계산: " + e.getValue())
                .collect(Collectors.toList());
    }
    @Override
    public void clear() {
        db.clear();
    }
}
