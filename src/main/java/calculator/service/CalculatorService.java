package calculator.service;

import calculator.domain.Expression;
import calculator.domain.repository.CalculatorRepository;

import java.util.*;

public class CalculatorService {
    private final CalculatorProcessor calculatorProcessor;
    private final CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorProcessor calculatorProcessor, CalculatorRepository calculatorRepository) {
        this.calculatorProcessor = calculatorProcessor;
        this.calculatorRepository = calculatorRepository;
    }

    // 이거 테스트는 CalculatorRepositoryTest에서 하는 게 낫나요
    // CalculatorServiceTest에서 하는 게 낫나요?
    public Map<Expression, Integer> getHistory() {
        return calculatorRepository.findAll();
    }

    public int process(Expression expression) {
        int result = calculatorProcessor.calculate(expression);
        calculatorRepository.save(expression, result);

        return result;
    }
}
