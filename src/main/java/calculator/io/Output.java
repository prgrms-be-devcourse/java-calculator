package calculator.io;

import java.io.IOException;

public interface Output {
    void inputError(String errorMsg) throws IOException;
    void output(String result) throws IOException;
}
