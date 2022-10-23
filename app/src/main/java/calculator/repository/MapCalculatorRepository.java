package calculator.repository;

import java.util.*;

public class MapCalculatorRepository implements CalculatorRepository {

    private final Map<Integer, String> repository;

    public MapCalculatorRepository() {
        this.repository = new LinkedHashMap<>();
    }

    @Override
    public void save(String expression) {
        repository.put(repository.size(), expression);
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(repository.values());
    }
}
