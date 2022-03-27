package service;

import io.Output;
import io.OutputImpl;
import repository.CalculatorRepository;
import repository.CalculatorRepositoryImpl;

import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {
    private final CalculatorRepository repository = new CalculatorRepositoryImpl();
    private final Output output = new OutputImpl();
    @Override
    public Double calculate() {
        return null;
    }

    @Override
    public void getResults() {
        output.printResult(
                repository.getResults().toString());
    }
}
