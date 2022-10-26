package engine.io;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String showOption(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public String getCalculateSentence(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
