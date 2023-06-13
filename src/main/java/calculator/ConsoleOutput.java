package calculator;

import calculator.io.Output;

public class ConsoleOutput implements Output {
    @Override
    public void print(String output) {
        System.out.println("\n" + output + "\n");
    }
}
