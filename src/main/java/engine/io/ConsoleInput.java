package engine.io;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showOption(String guideMessage) {
        System.out.println(guideMessage);
    }

    @Override
    public String getCalculateSentence(String guideMessage) {
        System.out.println(guideMessage);
        return scanner.nextLine();
    }

    @Override
    public String getUserInputOption() {
        String userInput = scanner.nextLine();
        return userInput.trim();
    }
}
