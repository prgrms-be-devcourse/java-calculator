package engine;

import engine.io.*;
import engine.repository.CalculatorRepository;

import java.util.List;

public class Calculator implements Runnable {

    private final CalculatorRepository repository;

    private final Input input;
    private final Output output;

    public Calculator(CalculatorRepository repository, Input input, Output output) {
        this.repository = repository;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {

        while (true) {
            String inputString = input.initialInput();

            int inputValue = Integer.parseInt(inputString);

            switch (inputValue) {
                case 1:     //조회
                    List<String> formulaList = repository.findAllValues();
                    for (String f : formulaList) {
                        output.formula(f);
                    }
                    break;
                case 2:     //계산
                    String inputFormula = input.input();
                    String answer = cal(inputFormula);
                    output.output(answer);
                    save(inputFormula, answer);
                    break;
                default:
                    output.inputError();
            }

        }

    }

}
