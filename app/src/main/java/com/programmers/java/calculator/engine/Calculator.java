package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.io.Console;
import com.programmers.java.calculator.engine.model.Arithmetic;
import com.programmers.java.calculator.engine.repository.LogRepository;
import com.programmers.java.calculator.engine.repository.Repository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable{
    private Console input;
    private Console output;
    private Repository repository = new LogRepository();

    static final String exit = "0";
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
                case exit -> {
                    return;
                }
                case printLog -> repository.printLog();
                case calculate -> checkValidate(input, output, repository);
                default -> output.inputError();
            }
        }
    }

    private void checkValidate(Console input, Console output, Repository repository) {
        {
            String inputString = input.input("\n");
            Arithmetic arithmetic = new Validation().tokenize(inputString);
            if (arithmetic.getArithmetic().isEmpty()) {
                output.inputError();
            } else {
                runCalculate(output, arithmetic, repository, inputString);
            }
        }
    }

    private void runCalculate(Console output, Arithmetic arithmetic, Repository repository, String inputString) {
        Calculation calculation = new Calculation();
        Arithmetic postfix = calculation.toPostfix(arithmetic);
        double result = calculation.doCalculation(postfix);

        output.outputCalculationResult(result);
        repository.save(arithmeticToString(inputString, result));
    }

    private String arithmeticToString(String arithmetic, double result) {
        return arithmetic + " = " + result;
    }
}
