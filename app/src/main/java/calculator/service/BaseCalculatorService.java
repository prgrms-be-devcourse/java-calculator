package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Command;

import java.util.List;
import java.util.Scanner;

import static calculator.domain.Command.*;

public class BaseCalculatorService implements CalculatorService {

    private final Calculator calculator;

    Scanner reader = new Scanner(System.in);
    StringBuilder writer = new StringBuilder();

    public BaseCalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        String introduction = makeIntroduction();
        System.out.println(introduction);

        while (reader.hasNextLine()) {
            String command = reader.nextLine();
            System.out.println("선택 : " + command);

            if (command.equals(GETALLDATA.getCode())) {
                getAllData();
            }
            else if (command.equals(CALCULATE.getCode())) {
                calculate();
            }
           else {
               System.out.println("> 다시 입력해주세요");
           }

            System.out.println(introduction);
        }
    }

    private String makeIntroduction(){
        String introduction = "";
        for (Command c : Command.values()) {
            introduction = introduction.concat(c.getCode() + ". " + c.getCommand() + "\n");
        }
        return introduction;
    }

    private void getAllData() {
        List<String> data = calculator.getAllData();
        for (String datum : data) {
            writer.append(datum).append("\n");
        }
        if (data.size() == 0)
            System.out.println("> 조회할 데이터가 없습니다");
        else {
            System.out.println(writer);
            writer.setLength(0);
        }
    }

    private void calculate() {
        String expression = reader.nextLine();
        int answer = calculator.calculate(expression);
        System.out.println(answer);
    }

    private void exit() {
        System.out.println("> 계산기 프로젝트를 종료합니다");
        reader.close();
    }
}
