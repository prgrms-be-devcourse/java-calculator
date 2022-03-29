package calculator.io;

import java.util.Scanner;

public class Console implements Input{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
