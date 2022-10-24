package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Command;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static calculator.domain.Command.*;

public class BaseCalculatorService implements CalculatorService {

    private final Calculator calculator;
    private final Scanner reader;
    private final PrintStream writer;

    public BaseCalculatorService(Calculator calculator) {
        this.calculator = calculator;
        this.reader = new Scanner(System.in);
        this.writer = new PrintStream(System.out);
    }

    public BaseCalculatorService(Calculator calculator, InputStream input, OutputStream output) {
        this.calculator = calculator;
        this.reader = new Scanner(input);
        this.writer = new PrintStream(output);
    }

    public void run() {
        String introduction = makeIntroduction();
        System.out.println(introduction);

        while (reader.hasNextLine()) {
            String command = reader.nextLine();
            writer.println("선택 : " + command);

            try {
                if (command.equals(GETALLDATA.getCode())) {
                    getAllData();
                } else if (command.equals(CALCULATE.getCode())) {
                    calculate();
                } else if (command.equals(EXIT.getCode())) {
                    exit();
                    break;
                } else {
                    writer.println("> 다시 입력해주세요");
                }
            } catch (ArithmeticException e) {
                writer.println("> 0으로 나눌 수 없습니다. 다시 입력해주세요");
            }

            writer.println(introduction);
        }
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
        int answer = calculator.calculate(expression);
        writer.println(answer);
    }

    private void exit() {
        writer.println("> 계산기 프로젝트를 종료합니다");
        reader.close();
    }
}
