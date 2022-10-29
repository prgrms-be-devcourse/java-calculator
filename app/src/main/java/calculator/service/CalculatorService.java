package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Command;
import calculator.io.Input;
import calculator.io.Output;

import java.util.List;

import static calculator.domain.Command.*;

public class CalculatorService {

    private final Calculator calculator;
    private final Input input;
    private final Output output;
    boolean exit = false;

    public CalculatorService(Calculator calculator, Input input, Output output) {
        this.calculator = calculator;
        this.input = input;
        this.output = output;
    }

    public void run() {
        String introduction = makeIntroduction();
        System.out.println(introduction);

        while (!exit) {
            try {
                Command command = getCommand(input.readLine());
                output.write("선택 : " + command.getCode());

                switch (command) {
                    case GETALLDATA -> getAllData();
                    case CALCULATE -> calculate();
                    case EXIT -> exit();
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

    private void getAllData() {
        StringBuilder sb = new StringBuilder();
        List<String> data = calculator.getAllData();
        for (String datum : data) {
            sb.append(datum).append("\n");
        }
        if (data.size() == 0)
            output.write("> 조회할 데이터가 없습니다");
        else {
            output.write(sb.toString());
        }
    }

    private void calculate() {
        String expression = input.readLine();
        String answer = calculator.calculate(expression);
        output.write(answer);
    }

    private void exit() {
        output.write("> 계산기 프로젝트를 종료합니다");
        exit = true;
    }
}
