import calculator.global.Menu;
import calculator.io.Input;
import calculator.io.Output;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorConsole implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void putMenu() {
        Arrays.stream(Menu.values())
                .forEach(m -> System.out.println(m.toString()));
    }

    @Override
    public void showCalculationResult(List<String> calcResults) {
        System.out.println();
        calcResults.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void inputError(String errorResponse) {
        System.out.println(errorResponse + "\n");
    }

    @Override
    public void showResult(Integer calculationResult) {
        System.out.println(calculationResult + "\n");
    }

    @Override
    public String getChoice(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public String getExpression() {
        System.out.println();
        return scanner.nextLine();
    }
}
