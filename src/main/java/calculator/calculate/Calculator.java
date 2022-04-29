package calculator.calculate;

import java.io.IOException;

public interface Calculator {
    Integer calculate(String expr);

    Boolean isValidExpression(String expr);

    void run() throws IOException;
}
