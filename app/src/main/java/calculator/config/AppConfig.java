package calculator.config;

import calculator.domain.BaseCalculator;
import calculator.domain.Calculator;
import calculator.io.ConsoleInput;
import calculator.io.ConsoleOutput;
import calculator.io.Input;
import calculator.io.Output;
import calculator.repository.MapCalculatorRepository;
import calculator.service.CalculatorService;

import java.io.*;

public class AppConfig {

    private static final Calculator calculator = new BaseCalculator(new MapCalculatorRepository());
    private static final Input input = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
    private static final Output output = new ConsoleOutput(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final CalculatorService calculatorService = new CalculatorService(calculator, input, output);

    public CalculatorService calculatorService() {
        return calculatorService;
    }
}