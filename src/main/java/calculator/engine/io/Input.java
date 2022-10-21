package calculator.engine.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private BufferedReader bufferedReader;

    public Input() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public UserSelection readSelection() {

    }

    private String read() throws IOException {
        return bufferedReader.readLine();
    }
}
