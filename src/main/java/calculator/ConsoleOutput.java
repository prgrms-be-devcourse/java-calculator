package calculator;

import calculator.io.Output;
import calculator.model.Result;

import java.util.List;

public class ConsoleOutput implements Output {
    @Override
    public void print(String output) {
        System.out.println("\n" + output + "\n");
    }

    @Override
    public void print(List<Result> list) {
        list.forEach(System.out::println);
    }
}
