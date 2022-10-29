package calculator.io;

import java.io.BufferedWriter;
import java.io.IOException;

public class ConsoleOutput implements Output {

    private final BufferedWriter writer;

    public ConsoleOutput(BufferedWriter writer) {
        this.writer = writer;
    }

    public void write(String string) {
        try {
            writer.write(string + "\n");
            writer.flush();
        } catch (IOException ignored) {
        }
    }
}
