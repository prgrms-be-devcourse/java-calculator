package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.io.Console;
import com.programmers.java.calculator.engine.model.Arithmetic;
import com.programmers.java.calculator.engine.repository.LogRepository;
import com.programmers.java.calculator.engine.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Calculator implements Runnable{
    private Console input;
    private Console output;
    private Repository repository = new LogRepository();

    static final String printLog = "1";
    static final String calculate = "2";

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
                case printLog -> repository.output();
                case calculate -> checkValidate(input, output, repository);
                default -> output.inputError();
            }
        }
    }

    private static void checkValidate(Console input, Console output, Repository repository) {
        {
            String inputString = input.input("\n");
            Optional<Arithmetic> arithmetic = new Validation().checkValid(inputString);
            if (arithmetic.isEmpty()) {
                output.inputError();
            } else {
                runCalculate(output, arithmetic.get(), repository, inputString);
            }
        }
    }

    private static void runCalculate(Console output, Arithmetic arithmetic, Repository repository, String inputString) {
        Calculation calculation = new Calculation();
        Arithmetic postfix = calculation.toPostfix(arithmetic);
        Optional<Double> result = calculation.doCalculation(postfix);

        if (result.isEmpty()) {
            output.calcError();
        } else {
            output.outputCalculationResult(result.get());
            repository.save(arithmeticToString(inputString, result.get()));
        }
    }

    private static String arithmeticToString(String arithmetic, Double result) {
        return arithmetic + " = " + result;
    }
}
