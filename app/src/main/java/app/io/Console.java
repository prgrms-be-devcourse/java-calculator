package app.io;

import app.calculator.Answer;
import app.calculator.Select;

import java.util.Scanner;

// 사용자 입출력값
public class Console implements Input, Output{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Select selectInput() {
        System.out.println("1. 조회 \n2. 계산\n3. 종료");
        String selectNumber = scanner.nextLine();
        selectOutput(selectNumber);

        return Select.findSelect(selectNumber);
    }

    @Override
    public String calculateInput() {
        return scanner.nextLine();
    }

    @Override
    public void selectOutput(String selectNumber) {
        System.out.println("선택 : " + selectNumber);
    }

    @Override
    public void lookUpOutput(String calculateHistory) {
        System.out.println(calculateHistory);
    }

    @Override
    public void calculateOutput(Answer calculateResult) {
        System.out.println(calculateResult.getCorrectAnswer());
    }

    @Override
    public void quitProgram() {
        System.out.println("프로그램을 종료합니다.");
    }
}
