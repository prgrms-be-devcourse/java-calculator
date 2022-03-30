import entity.CustomLog;
import repository.InMemoryLogRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new PostfixCalculator(
                new BufferedReader(new InputStreamReader(System.in)),
                new InMemoryLogRepository<CustomLog>(),
                new Prefix2PostfixConverter());

        calculator.run();
    }

}
