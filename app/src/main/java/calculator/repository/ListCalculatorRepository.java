package calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class ListCalculatorRepository implements CalculatorRepository {

    private final List<String> repository;

    public ListCalculatorRepository() {
        this.repository = new ArrayList<>();
    }

    @Override
    public void save(String expression) {
        repository.add(expression);
    }

    @Override
    public List<String> getAll() {
        return repository;
    }
}
