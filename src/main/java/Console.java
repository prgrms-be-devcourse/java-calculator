import io.Input;
import io.Output;
import model.Result;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console implements Input, Output {

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

    @Override
    public void inputError(String message) {
        System.out.println("\n" + message + "\n");
    }

    @Override
    public void results(List<Result> results) {
        String output = results.stream()
                .map(result -> result.getProblem() + " = " + result.getAnswer())
                        .collect(Collectors.joining("\n"));
        System.out.println("\n" + output + "\n");
    }

    @Override
    public void answer(Result result) {
        System.out.println("\n" + result.getAnswer() + "\n");
    }
}
