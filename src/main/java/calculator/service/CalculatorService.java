package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.PostFixCalculator;
import calculator.exception.NotSaveException;
import calculator.repository.CalculatorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatorService {
    private CalculatorRepository calculatorRepository;
    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public double calculate(String userInput) {
        Calculator calculator = PostFixCalculator.parseCalculator(userInput);

        if (this.calculatorRepository.add(calculator)) {
            return calculator.getResult();
        }

       throw new NotSaveException();
    }

    public List<String> getCalculateList() {
        List<Calculator> calculators = this.calculatorRepository.findAll();
        return calculators.stream()
                .map(Calculator::toString)
                .collect(Collectors.toList());
    }
}
