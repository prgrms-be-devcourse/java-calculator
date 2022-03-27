package consoleview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView {
    private final String mainMessage = "1. 조회\n2. 계산\n\n선택 : ";
    public void display() {
        this.display(mainMessage);
    }
    public void display(String message) {
        System.out.print(message);
    }

    public String getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();
        this.display("\n");
        return userInput;
    }
}
