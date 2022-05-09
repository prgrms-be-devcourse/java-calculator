package calculator.module.ui;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputString() {
        return scanner.nextLine();
    }

    @Override
    public void showMenu(){
        printMessage("=============================");
        printMessage("1.조회");
        printMessage("2.계산");
        printMessage("3.종료");
        printMessage("=============================");
        printMessage("명령을 입력하세요 : ");
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
