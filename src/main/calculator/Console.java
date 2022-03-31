package main.calculator;

import main.calculator.engine.io.Input;
import main.calculator.engine.io.Output;

import java.util.Scanner;

public class Console implements Output, Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String s) {
        System.out.println(s);
        return scanner.nextLine();
    }

    @Override
    public void menu() {
        System.out.println("1.조회 \n2.계산 \n3.종료");
    }

    @Override
    public void inputError() {
        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
    }

    @Override
    public void quit() {
        System.out.println("종료합니다.");
    }

    @Override
    public void print(String content) {
        System.out.println(content);
    }
}
