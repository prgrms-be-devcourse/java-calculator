package java.calculator.console.writer;

import java.calculator.common.writer.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
