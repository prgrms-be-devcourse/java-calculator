package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.Console;
import com.programmers.java.calculator.engine.io.Input;
import com.programmers.java.calculator.engine.io.Output;
import com.programmers.java.calculator.engine.model.Arithmetic;
import com.programmers.java.calculator.engine.repository.LogRepository;
import com.programmers.java.calculator.engine.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Calculator implements Runnable{
    private Input input;
    private Output output;
    Validation validation = new Validation();
    Calculation calculation = new Calculation();
    Repository repository = new LogRepository();

    public Calculator(Console input, Console output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {

        while (true) {
            output.outputChoiceMessage();

            String choice = (input.input("선택 : "));

            switch (choice) {
                case "1" -> repository.output();
                case "2" -> {
                    String inputString = input.input("\n");
                    Optional<Arithmetic> arithmetic = validation.checkValid(inputString);
                    if (arithmetic.isEmpty()) {
                        output.inputError();
                    } else {
                        Arithmetic postfix = calculation.toPostfix(arithmetic.get());
                        Optional<Double> result = calculation.doCalculation(postfix);

                        if (result.isEmpty()) {
                            output.calcError();
                        } else {
                            output.outputCalculationResult(result.get());
                            repository.save(arithmeticToString(inputString, result.get()));
                        }
                    }
                }
                default -> output.inputError();
            }
        }
    }

    private String arithmeticToString (String arithmetic, Double result) {
        return arithmetic + " = " + result;
    }
}
