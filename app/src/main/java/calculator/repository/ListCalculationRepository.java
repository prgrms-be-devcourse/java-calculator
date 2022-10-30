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
        for (CalculationResultHistory his : repository) {
            if (his.getExpression().equals(expression))
                return Optional.of(his.getAnswer());
        }
        return Optional.empty();
    }
}
