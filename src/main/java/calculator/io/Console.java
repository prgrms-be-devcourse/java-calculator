package calculator.io;

import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void answerPrint(int answer) {
        System.out.println(answer);
    }

    @Override
    public void historyPrint(Map<String, Integer> store) {
        store.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}
