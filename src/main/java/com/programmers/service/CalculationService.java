package com.programmers.service;

import com.programmers.domain.Calculator;
import com.programmers.domain.Tokenizer;
import com.programmers.domain.model.Calculation;
import com.programmers.enumtype.ServiceSelection;
import com.programmers.io.Input;
import com.programmers.io.Output;
import com.programmers.repository.CalculationRepository;

import java.util.List;

public class CalculationService implements Runnable {
    private final Tokenizer tokenizer = new Tokenizer();
    private final Calculator calculator = new Calculator();

    private final CalculationRepository calculationRepository;
    private final Input input;
    private final Output output;

    public CalculationService(CalculationRepository calculationRepository, Input input, Output output) {
        this.calculationRepository = calculationRepository;
        this.input = input;
        this.output = output;
    }

    public int calculate(String input) {
        List<String> tokenized = tokenizer.tokenize(input);
        int result = calculator.calculateInfixExpression(tokenized);

        saveCalculation(tokenized, result);

        return result;
    }

    private void saveCalculation(List<String> tokenized, int result) {
        Calculation calculation = new Calculation(tokenized, result);

        calculationRepository.save(calculation);
    }

    public List<Calculation> findCalculations() {
        return calculationRepository.findAll();
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
                List<Calculation> findCalculations = findCalculations();
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
