package calculator.view.output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public interface BaseOutput {

    default void print(String text) {
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write(text);
            bw.flush();
        } catch (IOException e) {
            throw  new NullPointerException();
        }
    }
}
