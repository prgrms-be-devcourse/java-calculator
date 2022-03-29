package io;

import java.util.Scanner;

public class Console implements Input, Output {

    private Scanner sc = new Scanner(System.in);

    @Override
    public String inputFormula() {
        return sc.nextLine();
    }

    @Override
    public String inputCommand(String prompt) {
        System.out.println(prompt);

        System.out.print("선택 : ");
        String s = sc.nextLine();
        return s;
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
