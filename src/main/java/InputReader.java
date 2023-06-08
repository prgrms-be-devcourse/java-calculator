import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public CommandType readUserCommand() {
        int commandNumber = scanner.nextInt();
        return CommandType.getCommandType(commandNumber);
    }
}
