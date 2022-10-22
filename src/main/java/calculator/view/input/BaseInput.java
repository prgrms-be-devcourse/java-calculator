package calculator.view.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public interface BaseInput {

    default String read() {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String inputValue = "";
        try {
            inputValue = br.readLine();
        } catch (IOException e) {
            throw new InputMismatchException();
        }

        return inputValue;
    }
}
