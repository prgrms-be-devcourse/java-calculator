package com.programmers.service;

import com.programmers.domain.Calculator;
import com.programmers.domain.Tokenizer;
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
        StringBuilder calculationBuilder = new StringBuilder();
        for (String token : tokenized) {
            calculationBuilder.append(token);
            calculationBuilder.append(" ");
        }
        calculationBuilder.append("= ");
        calculationBuilder.append(result);

        calculationRepository.save(calculationBuilder.toString());
    }

    public List<String> findCalculations() {
        return calculationRepository.findAll();
    }

    @Override
    public void run() {
        while (true) {
            String selected = input.selectService();

            boolean exitService = selectService(selected);

            if (exitService) {
                break;
            }
        }
    }

    private boolean selectService(String selected) {
        boolean exitService = false;

        ServiceSelection service = ServiceSelection.selectService(selected);
        switch (service) {
            case NOT_SELECTED -> {
                output.inputError();
            }
            case LOOKUP_RECORDS -> {
                List<String> findCalculations = findCalculations();
                output.printResult(findCalculations);
            }
            case CALCULATION -> {
                String calculation = input.inputCalculation();
                try {
                    int result = calculate(calculation);
                    output.printResult(result);
                } catch (RuntimeException ex) {
                    output.printError(ex);
                }
            }
            case EXIT_SERVICE -> {
                output.exit();
                exitService = true;
            }
        }
        return exitService;
    }
}
