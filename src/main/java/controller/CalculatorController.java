package controller;

import io.CalculatorInput;
import io.CalculatorOutput;
import model.calculation.Calculation;
import model.converter.Converter;
import model.repository.CalculatorRepository;
import model.vo.CalculationResult;
import model.vo.Expression;
import model.vo.Menu;

public class CalculatorController implements Runnable {
    private final CalculatorInput input;
    private final CalculatorOutput output;
    private final Converter converter;
    private final Calculation calculation;
    private final CalculatorRepository repository;

    public CalculatorController(CalculatorInput input, CalculatorOutput output, Converter converter, Calculation calculation, CalculatorRepository repository) {
        this.input = input;
        this.output = output;
        this.converter = converter;
        this.calculation = calculation;
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {
            //no switch
        }
    }
}
