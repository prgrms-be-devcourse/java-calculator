package programmers.java.calulator.console.writer;

import programmers.java.calulator.common.writer.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
