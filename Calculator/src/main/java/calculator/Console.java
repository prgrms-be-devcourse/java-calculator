package calculator;

import calculator.engine.io.Input;
import calculator.engine.io.Output;

import java.util.HashMap;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void Calculation(double result) {
        System.out.println(result);
    }

    @Override
    public void History(HashMap<String, Double> map) {
        if (map.isEmpty()) System.out.println("계산 이력이 없습니다.");
        else {
            map.forEach((key, value) -> {
                System.out.println(key + " = " + value);
            });
        }
    }
}
