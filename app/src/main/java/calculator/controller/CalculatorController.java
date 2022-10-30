package calculator.controller;

import calculator.domain.Command;
import calculator.io.Input;
import calculator.io.Output;
import calculator.service.CalculatorService;

import static calculator.domain.Command.*;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final Input input;
    private final Output output;

    public CalculatorController(CalculatorService calculatorService, Input input, Output output) {
        this.calculatorService = calculatorService;
        this.input = input;
        this.output = output;
    }

    public void run() {
        boolean exit = false;
        String introduction = makeIntroduction();
        System.out.println(introduction);

        while (!exit) {
            try {
                Command command = getCommand(input.readLine());
                output.write("선택 : " + command.getCode());

                switch (command) {
                    case GETALLDATA -> {
                        String rtn = calculatorService.getAllData();
                        output.write(rtn);
                    }
                    case CALCULATE -> {
                        String expression = input.readLine();
                        String rtn = calculatorService.calculate(expression);
                        output.write(rtn);
                    }
                    case EXIT -> {
                        String rtn = calculatorService.exit();
                        output.write(rtn);
                        exit = true;
                    }
                }
            } catch (RuntimeException e) {
                output.write("> " + e.getMessage());
            }

            if (!exit) output.write(introduction);
        }
        input.close();
    }

    private String makeIntroduction() {
        String introduction = "\n";
        for (Command c : Command.values()) {
            introduction = introduction.concat(c.getCode() + ". " + c.getCommand() + "\n");
        }
        return introduction;
    }

}
