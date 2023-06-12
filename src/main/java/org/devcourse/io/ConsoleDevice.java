package org.devcourse.io;

import java.util.*;

public class ConsoleDevice implements IODevice {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputMenu() {

        System.out.print("메뉴 선택=> ");
        return scanner.nextLine();

    }

    @Override
    public String inputExpression() {

        System.out.print("수식 입력 => ");
        return scanner.nextLine().replaceAll(" ", "");

    }

    @Override
    public void outputSingleResult(String res) {
        System.out.println(res + "\n");
    }

    @Override
    public void outputList(List<String> outputList) {

        for (String res : outputList) {
            System.out.println(res);
        }
        System.out.println();
    }

}
