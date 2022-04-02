package calculator.engine;


import calculator.io.Input;
import calculator.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public String initMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. 조회").append("\n");
        sb.append("2. 계산").append("\n");
        sb.append("3. 종료").append("\n");
        sb.append("\n선택 : ");

        System.out.print(sb);

        String input = input();

        return input;
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public void illegalExceptionMessage() {
        System.out.println("\n잘못된 식을 입력하셨습니다. 다시 입력해주세요.");
    }

    @Override
    public void exceptionMessage() {
        System.out.println("\n알수없는 오류가 발생하였습니다.\n");
    }

    @Override
    public void divisionByZero() {
        System.out.println("\n0으로 값을 나눌 수 없습니다. 식을 다시 입력해주세요.");
    }

    @Override
    public void exitMessage() {
        System.out.println("계산기를 종료합니다.");
    }

    @Override
    public void selectionError() {
        System.out.println("\n번호를 확인해주세요.\n");
    }
}
