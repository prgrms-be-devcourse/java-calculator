import engine.io.InputConsole;
import engine.io.OutputConsole;

import java.util.Scanner;

public class Console implements InputConsole, OutputConsole {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String menuInput() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");
        return scanner.nextLine();
    }

    @Override
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public void output(String s) {
        System.out.println(s);
    }

    @Override
    public void formula(String formula) {
        System.out.println(formula);
    }

    @Override
    public void inputError() {
        System.out.println("잘못된 입력입니다.");
    }
}
