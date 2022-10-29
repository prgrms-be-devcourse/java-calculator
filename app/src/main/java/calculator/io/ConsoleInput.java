package calculator.io;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleInput implements Input {
    private final BufferedReader reader;

    public ConsoleInput(BufferedReader reader) {
        this.reader = reader;
    }

    public String readLine() {
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException ignored) {
        }
        return input;
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException ignored) {
        }
    }
}
