package calculator.config;

import calculator.domain.BaseCalculator;
import calculator.domain.Calculator;
import calculator.io.ConsoleInput;
import calculator.io.ConsoleOutput;
import calculator.io.Input;
import calculator.io.Output;
import calculator.repository.ListCalculationRepository;
import calculator.repository.MapCalculatorRepository;
import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;

import java.io.*;

public class AppConfig {

    private static final Calculator calculator = new BaseCalculator(new ListCalculationRepository());
    private static final Input input = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
    private static final Output output = new ConsoleOutput(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final CalculatorService calculatorService = new CalculatorService(calculator);
    private static final CalculatorController calculatorController = new CalculatorController(calculatorService, input, output);

    public CalculatorController calculatorService() {
        return calculatorController;
    }
}