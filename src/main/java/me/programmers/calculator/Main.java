package me.programmers.calculator;

import me.programmers.calculator.engine.Calculator;
import me.programmers.calculator.engine.excpetion.Validator;
import me.programmers.calculator.engine.io.Console;
import me.programmers.calculator.engine.io.Input;
import me.programmers.calculator.engine.io.Output;
import me.programmers.calculator.engine.model.History;

import java.util.Map;

public class Main {
    private final String HISTORY = "1";
    private final String CALCULATE = "2";

    public static void main(String[] args) {
        Console console = new Console();
        new Main().run(console, console);
    }

    public void run(Input input, Output output) {
        History history = new History();
        Calculator calculator = new Calculator();
        Validator validator = new Validator();

        while (true) {
            String prompt = showMenu(output, input);

            switch (prompt) {
                case HISTORY:
                    showHistory(output, history);
                    break;
                case CALCULATE:
                    calculateNumberFormula(input, output, history, calculator, validator);
                    break;
                default:
                    output.output("숫자를 잘못 입력했습니다.\n");
                    break;
            }
        }
    }

    private void calculateNumberFormula(Input input, Output output, History history, Calculator calculator, Validator validator) {
        try {
            String problemString = input.problemInput();
            validator.problemValidate(problemString);
            long result = calculator.calculateFormula(problemString);
            history.saveMemory(problemString, result);
            output.output(result + "\n");
        } catch (Exception e) {
            output.output(e.getMessage() + "\n");
        }
    }

    private void showHistory(Output output, History history) {
        Map<Integer, String> memory = history.getMemory();
        for (int key = 1; key <= memory.size(); key++) {
            output.output(memory.get(key));
        }
        output.output("\n");
    }

    private String showMenu(Output output, Input input) {
        output.output("1. 조회");
        output.output("2. 계산");
        return input.input("선택: ");
    }
}
