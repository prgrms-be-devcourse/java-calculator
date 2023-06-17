package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.PostFixCalculate;
import calculator.repository.CalculatorRepository;
import util.ExceptionMsg;
import util.IllegalException;
import util.model.CalculateRequest;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatorService {
    private final CalculatorRepository calculatorRepository;
    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public double calculate(CalculateRequest calculateRequest) {
        Calculator calculator = new Calculator(new PostFixCalculate());
        calculator.calculate(calculateRequest.getEquation());

        if (this.calculatorRepository.add(calculator)) {
            return calculator.getResult();
        }

       throw new IllegalException(ExceptionMsg.NotSaveException);
    }

    public List<String> getCalculateResults() {
        List<Calculator> calculators = this.calculatorRepository.findAll();
        return calculators.stream()
                .map(Calculator::toString)
                .collect(Collectors.toList());
    }
}
