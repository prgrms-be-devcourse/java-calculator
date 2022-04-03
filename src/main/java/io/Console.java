package io;

import java.util.Scanner;

public class Console implements Input, Output {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String inputFormula(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public String inputCommand(String prompt) {
        System.out.println(prompt);
        System.out.print("선택 : ");
        return scanner.nextLine();
    }

    @Override
    public void inputError() {
        System.out.println("잘못 된 입력 값입니다.");
    }

    @Override
    public void result(String result) {
        System.out.println(result);
    }


}
