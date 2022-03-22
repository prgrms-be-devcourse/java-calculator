package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryExpressionRepository implements ExpressionRepository {
    private static Map<Long, String> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(String expression) {
        store.put(sequence, expression);
        sequence++;
    }

    @Override
    public List<String> findAll() {
        return new ArrayList<>(store.values());
    }
}
