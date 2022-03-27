package calculator.console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private final BufferedReader br;

    public Console() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String input() throws IOException {
        return br.readLine();
    }

    public void print(String output) {
        System.out.println(output);
    }
}
