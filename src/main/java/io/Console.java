package io;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output{

    private final Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int choiceInput() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.print("선택 : ");
        return scanner.nextInt();
    }

    @Override
    public String expressionInput() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    @Override
    public void printAllExpressions(List<String> expressions) {
        if(expressions.isEmpty()) System.out.println("저장된 계산식이 없습니다.");
        expressions.forEach(System.out::println);
    }

    @Override
    public void printCalculatedNumber(double num) {
        System.out.println(String.format("%.2f", num));
    }

    @Override
    public void printChooseWrongNumber() {
        System.out.println("잘못된 번호 선택입니다");
    }
}
