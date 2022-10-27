package calculator.view.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

import static calculator.view.exception.BaseInputException.BASE_INPUT_EXCEPTION;

public interface BaseInput {

    default String read() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = "";

        try {
            inputValue = br.readLine();

            if (inputValue.length() == 0) {
                throw new IOException();
            }
        } catch (IOException e) {
            throw new InputMismatchException(BASE_INPUT_EXCEPTION.getMessage());
        }

        return inputValue;
    }
}
