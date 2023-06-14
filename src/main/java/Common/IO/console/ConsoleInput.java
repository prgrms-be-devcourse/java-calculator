package Common.IO.console;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner sc = new Scanner(System.in);

    public int getChoice() {
        return Integer.parseInt(sc.nextLine());
    }

    public String getExpression() {
        return sc.nextLine();
    }
}
