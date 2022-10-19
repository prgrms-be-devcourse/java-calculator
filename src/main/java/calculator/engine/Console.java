package calculator.engine;


import calculator.exception.DivisionByZero;
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
    public void exitMessage() {
        System.out.println("\n계산기를 종료합니다.");
    }

    @Override
    public void errorMessage(Exception e) {
        if(e instanceof DivisionByZero) {
            System.out.println("0으로 값을 나눌 수 없습니다.\n");
        } else if (e instanceof IllegalArgumentException) {
            System.out.println("\n입력값을 확인해 주세요.\n");
        } else {
            System.out.println("예상하지 못한 오류가 발생하였습니다.\n");
        }
    }
}
