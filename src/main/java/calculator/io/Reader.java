package calculator.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private BufferedReader bufferedReader;

    public Reader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public UserSelection readSelection() {

    }

    private String read() throws IOException {
        return bufferedReader.readLine();
    }
}
