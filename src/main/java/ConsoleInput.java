import io.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public String readWithPrompt(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
