import io.Output;
import model.Result;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutput implements Output {
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
    public void answer(int answer) {
        System.out.println("\n" + answer + "\n");
    }
}
