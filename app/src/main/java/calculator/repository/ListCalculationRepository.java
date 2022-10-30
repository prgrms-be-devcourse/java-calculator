package calculator.repository;

import calculator.domain.CalculationResultHistory;

import java.util.*;

public class ListCalculationRepository implements CalculatorRepository {

    private final List<CalculationResultHistory> repository;

    public ListCalculationRepository() {
        this.repository = new ArrayList<>();
    }

    @Override
    public void save(CalculationResultHistory result) {
        repository.add(result);
    }

    @Override
    public List<CalculationResultHistory> getAll() {
        return repository;
    }

    @Override
    public Optional<String> getResultFromExpression(String expression) {
        Optional<CalculationResultHistory> history = repository.stream().filter(f -> f.getExpression().equals(expression)).findAny();
        return Optional.ofNullable(history.get().getAnswer());
    }
}
