package calculator.repository;

import calculator.domain.CalculationResultHistory;

import java.util.*;

public class MapCalculatorRepository implements CalculatorRepository {

    private final Map<String, String> repository;

    public MapCalculatorRepository() {
        this.repository = new LinkedHashMap<>();
    }

    @Override
    public void save(CalculationResultHistory result) {
        repository.put(result.getExpression(), result.getAnswer());
    }

    @Override
    public List<CalculationResultHistory> getAll() {
        return repository.entrySet().stream().map(e -> new CalculationResultHistory(e.getKey(), e.getValue())).toList();
    }

    @Override
    public Optional<String> getResultFromExpression(String expression) {
        return Optional.ofNullable(repository.get(expression));
    }
}
