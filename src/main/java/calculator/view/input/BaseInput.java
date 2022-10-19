package calculator.view.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class BaseInput {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String read() {
        String inputValue = "";
        try {
            inputValue = br.readLine();
        } catch (IOException e) {
            throw new InputMismatchException();
        }

        return inputValue;
    }
}
