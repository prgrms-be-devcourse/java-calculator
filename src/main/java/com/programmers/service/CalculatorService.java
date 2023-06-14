package com.programmers.service;

import com.programmers.domain.Calculator;
import com.programmers.domain.Tokenizer;
import com.programmers.enumtype.ServiceSelection;
import com.programmers.io.Input;
import com.programmers.io.Output;
import com.programmers.repository.CalculatorRepository;

import java.util.List;

public class CalculatorService implements Runnable {
    private final CalculatorRepository calculatorRepository;
    private final Input input;
    private final Output output;

    public CalculatorService(CalculatorRepository calculatorRepository, Input input, Output output) {
        this.calculatorRepository = calculatorRepository;
        this.input = input;
        this.output = output;
    }

    public int calculate(String input) {
        List<String> tokenized = Tokenizer.tokenizeAsExpression(input);

        Calculator calculator = new Calculator(tokenized);
        int result = calculator.calculate();

        calculatorRepository.save(calculator);

        return result;
    }

    public List<Calculator> findCalculations() {
        return calculatorRepository.findAll();
    }

    @Override
    public void run() {
        while (true) {
            String serviceNumber = input.selectService();

            ServiceSelection selected = ServiceSelection.selectService(serviceNumber);

            boolean exitService = progressService(selected);
            if (exitService) {
                break;
            }
        }
    }

    private boolean progressService(ServiceSelection selected) {
        boolean exitService = false;
        try {
            exitService = selectService(selected);
        } catch (RuntimeException ex) {
            output.printError(ex);
        }

        return exitService;
    }

    private boolean selectService(ServiceSelection selectedService) {
        boolean exitService = false;
        switch (selectedService) {
            case NOT_SELECTED -> {
                output.inputError();
            }
            case LOOKUP_RECORDS -> {
                List<Calculator> findCalculations = findCalculations();
                output.printResult(findCalculations);
            }
            case CALCULATION -> {
                String calculation = input.inputCalculation();
                int result = calculate(calculation);
                output.printResult(result);
            }
            case EXIT_SERVICE -> {
                output.exit();
                exitService = true;
            }
        }

        return exitService;
    }
}
