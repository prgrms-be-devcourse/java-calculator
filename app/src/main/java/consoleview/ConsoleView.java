package consoleview;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleView {
    private final String mainMessage = "1. 조회\n2. 계산\n3. 종료\n\n선택 : ";
    private final String newline = "\n";
    private final String calculatorMessage = "계산식 : ";
    private final String errorMessage = "잘못된 입력입니다.\n";
    private Scanner sc;

    public ConsoleView() {
        sc = new Scanner(System.in);
    }

    public void display() {
        this.display(mainMessage);
    }

    public void display(String message) {
        System.out.print(message);
    }

    public String getUserInput() throws IOException {
        return sc.nextLine();
    }

    public void displayBlankLine() {
        this.display(newline);
    }

    public void displayCalculator() {
        this.displayBlankLine();
        this.display(calculatorMessage);
    }

    public void displayErrorMessage() {
        this.display(errorMessage);
        this.displayBlankLine();
    }

    public void close() {
        sc.close();
    }
}
