package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Command;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static calculator.domain.Command.*;

public class CalculatorService {

    private final Calculator calculator;
    private final Scanner reader;
    private final PrintStream writer;
    boolean exit = false;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
        this.reader = new Scanner(System.in);
        this.writer = new PrintStream(System.out);
    }

    public CalculatorService(Calculator calculator, InputStream input, OutputStream output) {
        this.calculator = calculator;
        this.reader = new Scanner(input);
        this.writer = new PrintStream(output);
    }

    public void run() {
        String introduction = makeIntroduction();
        System.out.println(introduction);

        while (!exit && reader.hasNextLine()) {
            try {
                Command command = getCommand(reader.nextLine());
                writer.println("선택 : " + command.getCode());

                switch (command) {
                    case GETALLDATA -> getAllData();
                    case CALCULATE -> calculate();
                    case EXIT -> exit();
                }
            } catch (RuntimeException e) {
                writer.println("> " + e.getMessage());
            }

            if (!exit) writer.println(introduction);
        }
        reader.close();
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
            writer.println("> 조회할 데이터가 없습니다");
        else {
            writer.println(sb);
        }
    }

    private void calculate() {
        String expression = reader.nextLine();
        String answer = calculator.calculate(expression);
        writer.println(answer);
    }

    private void exit() {
        writer.println("> 계산기 프로젝트를 종료합니다");
        exit = true;
    }
}
