package engine.io;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showOption(String message) {
        System.out.println(message);
    }

    @Override
    public String getCalculateSentence(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public String getUserInputOption() {
        String userInput = scanner.nextLine();
        return userInput.trim();
    }
}
