package com.programmers.service;

import com.programmers.domain.Calculator;
import com.programmers.domain.Tokenizer;
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
        String[] tokenized = tokenizer.tokenize(input);
        int result = calculator.calculateInfixExpression(tokenized);

        saveCalculation(tokenized, result);

        return result;
    }

    private void saveCalculation(String[] tokenized, int result) {
        StringBuilder calculationBuilder = new StringBuilder();
        for (String str : tokenized) {
            calculationBuilder.append(str);
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

            boolean exitService = false;
            switch (selected) {
                case "1":
                    List<String> findCalculations = findCalculations();
                    output.printResult(findCalculations);

                    break;
                case "2":
                    String calculation = input.inputCalculation();
                    try {
                        int result = calculate(calculation);
                        output.printResult(result);
                    } catch (RuntimeException ex) {
                        output.printError(ex);
                    }

                    break;
                case "3":
                    output.exit();
                    exitService = true;

                    break;
                default:
                    output.inputError();
            }

            if(exitService) {
                break;
            }
        }
    }
}
