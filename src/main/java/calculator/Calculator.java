package calculator;

import calculator.io.InfixToPostfixConverter;
import calculator.io.Input;
import calculator.io.Output;
import calculator.repository.CalculationRepository;


public class Calculator implements Runnable {
    private final InfixToPostfixConverter infixConverter;
    private final Input input;
    private final Output output;
    private final CalculationRepository calculationRepository;

    public Calculator(InfixToPostfixConverter infixConverter, Input input, Output output, CalculationRepository calculationRepository) {
        this.infixConverter = infixConverter;
        this.input = input;
        this.output = output;
        this.calculationRepository = calculationRepository;
    }


    @Override
    public void run() {
    }
}
