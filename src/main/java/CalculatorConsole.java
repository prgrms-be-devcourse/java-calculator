import calculator.global.Menu;
import calculator.io.Input;
import calculator.io.Output;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CalculatorConsole implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void putMenu() {
        Arrays.stream(Menu.values())
                .forEach(m -> System.out.println(m.toString()));
    }

    @Override
    public void showCalculationResult(LinkedHashMap<Integer, String> calculationResult) {
        calculationResult.values().forEach(System.out::println);
    }

    @Override
    public void inputError(String errorResponse) {
        throw new IllegalArgumentException(errorResponse);
    }

    @Override
    public String getChoice(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public String getExpression() {
        return scanner.nextLine();
    }
}
