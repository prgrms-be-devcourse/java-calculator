package calculator.repository;

import calculator.domain.CalculationResult;

import java.util.*;

public class MapCalculatorRepository implements CalculatorRepository {

    private final Map<String, String> repository;

    public MapCalculatorRepository() {
        this.repository = new LinkedHashMap<>();
    }

    @Override
    public void save(CalculationResult result) {
        repository.put(result.getExpression(), result.getAnswer());
    }

    @Override
    public List<String> getAll() {
        return repository.entrySet().stream().map(e -> e.getKey() + " = " + e.getValue()).toList();
    }

    @Override
    public Optional<String> getResultFromExpression(String expression) {
        if (repository.containsKey(expression))
            return Optional.of(repository.get(expression));
        else return Optional.empty();
    }
}
