import repository.CalcRepository;
import repository.InMemoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Calculator calculator = new PostfixCalculator(
                new BufferedReader(new InputStreamReader(System.in)),
                InMemoryRepository.getInstance(),
                new Prefix2PostfixConverter());

        calculator.run();
    }

}
