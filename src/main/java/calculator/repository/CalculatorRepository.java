package calculator.repository;

import calculator.domain.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorRepository {
    private List<Calculator> calculators;

    public CalculatorRepository() {
        this.calculators = new ArrayList<>();
    }

    public List<Calculator> findAll() {
        return calculators.stream()
                .map(Calculator::getCalculator)
                .collect(Collectors.toList());
    }

    public boolean add(Calculator calculator) {
        return this.calculators.add(calculator);
    }
}
