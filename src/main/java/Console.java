import calculator.engine.io.Input;
import calculator.engine.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String s) {
        ConsoleMenu();
        System.out.println(s);
        return scanner.nextLine();
    }
    @Override
    public String inputError() {
        return "입력 오류가 발생하였습니다.";
    }
    @Override
    public String outputError() {
        return "프로그램 오류가 발생하였습니다.";
    }
    public void ConsoleMenu() {
        System.out.println("1.조회");
        System.out.println("2.계산");
        System.out.println("선택: ");
    }
}
