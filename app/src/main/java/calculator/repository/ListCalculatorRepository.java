package calculator.repository;

import calculator.domain.CalculationResult;

import java.util.ArrayList;
import java.util.List;

public class ListCalculatorRepository implements CalculatorRepository {

    private final List<String> repository;

    public ListCalculatorRepository() {
        this.repository = new ArrayList<>();
    }

    @Override
    public void save(CalculationResult result) {
        repository.add(format(result));
    }

    @Override
    public List<String> getAll() {
        return repository;
    }

    private String format(CalculationResult result){
        return result.getExpression() + " = " + result.getAnswer();
    }
}
