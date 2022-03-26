package calculator.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryResultRepository implements ResultRepository {

    private static final List<String> store = new ArrayList<>();

    @Override
    public void save(String result) {
        store.add(result);
    }

    @Override
    public Optional<List<String>> findAll() {
        if (store.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new ArrayList<>(store));
    }

    public void clearStore() {
        store.clear();
    }
}
