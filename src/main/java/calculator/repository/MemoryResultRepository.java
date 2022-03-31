package calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class MemoryResultRepository implements ResultRepository {

    private static final List<String> store = new ArrayList<>();

    @Override
    public void save(String result) {
        store.add(result);
    }

    @Override
    public List<String> findAll() {
        return new ArrayList<>(store);
    }

    public void clearStore() {
        store.clear();
    }
}
